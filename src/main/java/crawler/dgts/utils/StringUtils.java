package crawler.dgts.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.Map;
import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringUtils {
	public static String clobToString(Clob clobObject) {
		final StringBuilder sb = new StringBuilder();

		try {
			final Reader reader = clobObject.getCharacterStream();
			final BufferedReader br = new BufferedReader(reader);

			int b;
			while (-1 != (b = br.read())) {
				sb.append((char) b);
			}

			br.close();
		} catch (SQLException e) {
			log.error("SQL. Could not convert CLOB to string", e);
			return e.toString();
		} catch (IOException e) {
			log.error("IO. Could not convert CLOB to string", e);
			return e.toString();
		}

		return sb.toString();
	}

	public static Clob stringToClob(String source) {
		try {
			return new javax.sql.rowset.serial.SerialClob(source.toCharArray());
		} catch (Exception e) {
			log.error("Could not convert string to a CLOB", e);
			return null;
		}
	}

	public static String removeHtmlParagraphTags(String source) {
		String result;
		try {
			result = source.replaceAll("<\\/?p>", "");
		} catch (Exception e) {
			log.error("StringUtils removeHtmlParagraphTags", e);
			result = source;
		}
		return result;
	}

	public static String getParameterByElement(Map<String, Object> lsParameters, String paramName) {
		try {
			if (lsParameters == null || lsParameters.size() <= 0)
				return null;
			return String.valueOf(lsParameters.get(paramName));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static Integer convertStringToInteger(String input, boolean required) throws Exception {
		Integer value = convertStringToInteger(input);
		if (required && value == null)
			throw new Exception("Invalid input");
		return value;
	}

	public static boolean convertStringToBoolean(String input) throws Exception {
		boolean value = input == null || input.equals("false") ? false : true;
		return value;
	}

	public static Integer convertStringToInteger(String input) {
		try {
			if (input == null || input.isEmpty())
				return null;
			return Integer.valueOf(input);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static String UppercaseWithStartCharacter(String str) {
		try {
			if (str != null && !str.equals("")) {
				StringBuilder sb = new StringBuilder(str);
				sb.setCharAt(0,Character.toUpperCase(sb.charAt(0)));
				return sb.toString();
			}
			return str;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	public static String deAccent(String str) {
		try {
			String temp = Normalizer.normalize(str, Normalizer.Form.NFD);
			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			return pattern.matcher(temp).replaceAll("").toLowerCase().replace("đ", "d");
		} catch (Exception ex) {
		}
		return "";
	}
	
}
