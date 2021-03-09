package crawler.dgts.utils;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class XSSUtils {
	public static void removeXSS(Object o) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = o.getClass().getDeclaredFields();
		String value = "";

		for (Field field : fields) {
			if (field.getType() == String.class) {
				field.setAccessible(true);
				value = (String) field.get(o);

				if (value != null) {
					// format xss
					value = StringEscapeUtils.unescapeHtml4(Jsoup.clean(value, Whitelist.basic()));

					// set again value
					field.set(o, value);
				}
			}
		}
	}
	public static void restoreXSS(Object o) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = o.getClass().getDeclaredFields();
		String value = "";

		for (Field field : fields) {
			if (field.getType() == String.class) {
				field.setAccessible(true);
				value = (String) field.get(o);

				if (value != null) {
					// format xss
					value = StringEscapeUtils.unescapeXml(value);

					// set again value
					field.set(o, value);
				}
			}
		}
	}
}
