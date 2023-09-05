package dare.beauty.cosmetics.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.rmi.ServerError;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData<T> implements Serializable {

    /**
     * @see {@link HttpStatus}
     */
    private int code;

    private String message;

    @JsonInclude(value = Include.NON_NULL)
    private List<ServerError> errors;

    @JsonInclude(value = Include.NON_NULL)
    private T data;

    public static <T> ResponseData<T> ok() {
        return restResult(HttpStatus.OK,HttpStatus.OK.getReasonPhrase(), null, null);
    }

    public static <T> ResponseData<T> ok(String message) {
        return restResult(HttpStatus.OK, message, null, null);
    }

    public static <T> ResponseData<T> ok(T responseData) {
        return restResult(HttpStatus.OK, HttpStatus.OK.getReasonPhrase(), null, responseData);
    }

    public static <T> ResponseData<T> created(T responseData) {
        return restResult(HttpStatus.CREATED, HttpStatus.CREATED.getReasonPhrase(), null, responseData);
    }

    public static <T> ResponseData<T> failed(HttpStatus status, String message) {
        return restResult(status, message, null, null);
    }

    public static <T> ResponseData<T> failed(HttpStatus status, String message, List<ServerError> error) {
        return restResult(status, message, error, null);
    }

    public static <T> ResponseData<T> failed(HttpStatus status, String message, List<ServerError> error, T responseData) {
        return restResult(status, message, error, responseData);
    }

    public static <T> ResponseData<T> build(HttpStatus status, String message, List<ServerError> error, T responseData) {
        return restResult(status, message, error, responseData);
    }

    private static <T> ResponseData<T> restResult(HttpStatus code, String message, List<ServerError> error, T responseData) {
        ResponseData<T> body = new ResponseData<>();
        body.setCode(code.value());
        body.setMessage(message);
        body.setErrors(error);
        body.setData(responseData);
        return body;
    }

}
