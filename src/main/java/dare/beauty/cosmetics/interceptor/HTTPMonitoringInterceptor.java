package dare.beauty.cosmetics.interceptor;

import dare.beauty.cosmetics.util.AppUtil;
import dare.beauty.cosmetics.util.JSONUtil;
import dare.beauty.cosmetics.util.StatePool;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.ThreadContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
@Log4j2
public class HTTPMonitoringInterceptor extends RequestBodyAdviceAdapter implements HandlerInterceptor, ResponseBodyAdvice<Object> {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ThreadContext.put("request_id", AppUtil.getUUID());
        if (DispatcherType.REQUEST.name().equals(request.getDispatcherType().name()) && request.getMethod().equals(HttpMethod.GET.name())) {
            logRequest(request, null);
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {

        logRequest(httpServletRequest, body);

        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        HttpHeaders headers = response.getHeaders();
        List<String> showLogs = headers.get(StatePool.HEADER_SHOW_LOG);
        String showLog = null;
        if (CollectionUtils.isNotEmpty(showLogs)) {
            showLog = showLogs.get(0);
        }
        if (request instanceof ServletServerHttpRequest && response instanceof ServletServerHttpResponse) {
            logResponse(((ServletServerHttpRequest) request).getServletRequest(), ((ServletServerHttpResponse) response).getServletResponse(), body,showLog);
        }

        return body;
    }


    private void logRequest(HttpServletRequest httpServletRequest, Object body) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, String> parameters = buildParametersMap(httpServletRequest);

        stringBuilder.append("REQUEST ");
        stringBuilder.append("method=[").append(httpServletRequest.getMethod()).append("] ");
        stringBuilder.append("path=[").append(httpServletRequest.getRequestURI()).append("] ");
//        stringBuilder.append("headers=[").append(buildHeadersMap(httpServletRequest)).append("] ");

        if (!parameters.isEmpty()) {
            stringBuilder.append("parameters=[").append(parameters).append("] ");
        }

        if (body != null) {

//            ObjectMapper mapper = new ObjectMapper();
//            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

            if (body instanceof Collection) {
                JSONArray jsonArr = new JSONArray();

                Iterator iterator = ((Collection) body).iterator();
                while (iterator.hasNext()) {
                    try {
                        JSONObject json = JSONUtil.toJson(iterator.next());
                        jsonArr.put(json);
                    } catch (Exception e) {
                        log.info("Can't build json from object");
                    }
                }

                stringBuilder.append("body=" + jsonArr.toString());
            } else {
                try {
                    JSONObject json = JSONUtil.toJson(body);
                    stringBuilder.append("body=" + json.toString());
                } catch (Exception e) {
                    log.info("Can't build json from object");
                }
            }
        }

        log.info(stringBuilder.toString());
    }

    private void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object body,String showLog) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("RESPONSE ");
        stringBuilder.append("method=[").append(httpServletRequest.getMethod()).append("] ");
        stringBuilder.append("path=[").append(httpServletRequest.getRequestURI()).append("] ");
//        stringBuilder.append("responseHeaders=[").append(buildHeadersMap(httpServletResponse)).append("] ");
        if (!StatePool.DISABLE.equalsIgnoreCase(showLog)) {
            try {

                if (!Objects.isNull(body)) {
                    JSONObject json = JSONUtil.toJson(body);
                    stringBuilder.append("responseBody=").append(json.toString());
                }

            } catch (Exception e) {
                log.info("Can't build json from object");
            }
        } else {
            log.info("Ignore logging response body");
        }

        log.info(stringBuilder.toString());
    }

    private Map<String, String> buildParametersMap(HttpServletRequest httpServletRequest) {
        Map<String, String> resultMap = new HashMap<>();
        Enumeration<String> parameterNames = httpServletRequest.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            String value = httpServletRequest.getParameter(key);
            resultMap.put(key, value);
        }

        return resultMap;
    }

    private Map<String, String> buildHeadersMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        return map;
    }

    private Map<String, String> buildHeadersMap(HttpServletResponse response) {
        Map<String, String> map = new HashMap<>();

        Collection<String> headerNames = response.getHeaderNames();
        for (String header : headerNames) {
            map.put(header, response.getHeader(header));
        }

        return map;
    }

}
