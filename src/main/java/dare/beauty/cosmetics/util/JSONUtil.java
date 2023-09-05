package dare.beauty.cosmetics.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JSONUtil {
	private static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	public static Map<String, Object> convertJSONToMap(String jsonString) {
		JSONObject jsonObject = new JSONObject(jsonString);
		return convertJSONToMap(jsonObject);
	}

	public static Map<String, Object> convertJSONToMap(JSONObject object) throws JSONException {
		Map<String, Object> map = new HashMap<String, Object>();

		Iterator<String> keysItr = object.keys();
		while (keysItr.hasNext()) {
			String key = keysItr.next();
			Object value = object.get(key);

			if (value instanceof JSONArray) {
				value = convertJSONToList((JSONArray) value);
			}

			else if (value instanceof JSONObject) {
				value = convertJSONToMap((JSONObject) value);
			}
			map.put(key, value);
		}
		return map;
	}

	public static List<Object> convertJSONToList(JSONArray array) throws JSONException {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < array.length(); i++) {
			Object value = array.get(i);
			if (value instanceof JSONArray) {
				value = convertJSONToList((JSONArray) value);
			}

			else if (value instanceof JSONObject) {
				value = convertJSONToMap((JSONObject) value);
			}
			list.add(value);
		}
		return list;
	}

	public static JSONObject toJson(Object object) throws Exception {
		String jsonStr = toStringJson(object);
		if (StringUtils.isNotEmpty(jsonStr)) {
			return new JSONObject(jsonStr);
		}
		return null;
	}

	public static Map toMap(Object object) throws Exception {
		String jsonStr = toStringJson(object);
		if (StringUtils.isNotEmpty(jsonStr)) {
			return mapper.readValue(jsonStr, Map.class);
		}
		return null;
	}
	public static String toStringJson(Object object) throws Exception {
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new Exception("Can't build json from object");
		}
		return jsonString;
	}

	public static <T> T jsonToPOJO(String json , Class<T> clazz) {
		try {
			T object = 	mapper.readValue(json,clazz);
			return object;
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return null;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

	//            khai bao class T -> List<T>
	public static <T> List<T> convertJSONToListPOJO(JSONArray array, Class<T> clazz) throws JSONException {
		List<T> list = new ArrayList<T>();
		for (int i = 0; i < array.length(); i++) {
			Object value = array.get(i);
			T object = jsonToPOJO(value.toString(), clazz);
			list.add(object);
		}
		return list;
	}

	public static <T> String convertListToString (List<T> list) {
		try {
			if (CollectionUtils.isNotEmpty(list)) {
				return mapper.writeValueAsString(list);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
