package crawler.dgts.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service("jsonService")
public class JsonService {

	private ObjectMapper om;

	public JsonService() {
		om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	}

	public ObjectMapper getObjectMapper() {
		return om;
	}

	private static JsonService singleton;

	public static JsonService getInstance() {
		if (singleton == null) {
			singleton = new JsonService();
		}
		return singleton;
	}

	public static ObjectMapper getOm() {
		return getInstance().getObjectMapper();
	}

	public static String writeToStringWithoutException(Object obj) {
		try {
			return getInstance().getObjectMapper().writeValueAsString(obj);
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

	public static byte[] writeToByteWithoutException(Object obj) {
		try {
			return getInstance().getObjectMapper().writeValueAsBytes(obj);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}