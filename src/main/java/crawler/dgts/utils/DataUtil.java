package crawler.dgts.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class DataUtil {
    public static boolean nonEmpty(String text) {
        return !nullOrEmpty(text);
    }

    public static boolean nullOrEmpty(Collection objects) {
        return objects == null || objects.isEmpty();
    }

    public static boolean nullOrEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean notNull(Object object) {
        return !nullObject(object);
    }

    public static boolean nullObject(Object object) {
        return object == null;
    }

    public static boolean nullOrZero(Long value) {
        return (value == null || value.equals(0L));
    }

    public static boolean nullOrZero(Float value) {
        return (value == null || value.equals(0F));
    }

    public static boolean nullOrZero(Integer value) {
        return (value == null || value.equals(0));
    }

    public static boolean isNotNullOrZero(Integer value) {
        return !nullOrZero(value);
    }

    public static boolean isNotNullOrZero(Float value) {
        return !nullOrZero(value);
    }

    public static boolean isNotNullOrZero(Long value) {
        return !nullOrZero(value);
    }

    public static Long parseToLong(Object value, Long defaultVal) {
        try {
            String str = parseToString(value);
            if (nullOrEmpty(str)) {
                return null;
            }
            return Long.parseLong(str);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return defaultVal;
        }
    }

    public static Long parseToLong(Object value) {
        if (value == null) {
            return null;
        }
        return parseToLong(value, null);
    }

    public static String parseToString(Object value, String defaultVal) {
        try {
            return String.valueOf(value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return defaultVal;
        }
    }

    public static String parseToString(Object value) {
        return parseToString(value, "");
    }

    public static boolean matchByPattern(String value, String regex) {
        if (nullOrEmpty(regex) || nullOrEmpty(value)) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public static boolean nullOrEmpty(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNullOrEmpty(CharSequence cs) {
        return nullOrEmpty(cs);
    }

    public static boolean isNullOrEmpty(final Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotNullOrEmpty(CharSequence cs) {
        return !isNullOrEmpty(cs);
    }

    public static boolean isNotNullOrEmpty(final Collection<?> collection) {
        return !isNullOrEmpty(collection);
    }

    public static String objectToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        if (object == null) {
            return null;
        }
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsString(object);
    }

    private static boolean safeEqualString(String str1, String str2, boolean ignoreCase, boolean trimspace) {
        if (str1 == null || str2 == null) {
            return false;
        }

        if (trimspace) {
            str1 = str1.trim();
            str2 = str2.trim();
        }

        if (ignoreCase) {
            return str1.equalsIgnoreCase(str2);
        } else {
            return str1.equals(str2);
        }
    }

    public static boolean safeEqualString(String str1, String str2) {
        return safeEqualString(str1, str2, false, true);
    }

    public static List<String> split(String separate, String object) {
        return Optional.ofNullable(object)
                .map(x -> x.split(separate))
                .map(Arrays::asList)
                .orElseGet(ArrayList::new);
    }

    public static boolean safeEqual(Object obj1, Object obj2) {
        return ((obj1 != null) && (obj2 != null) && obj2.toString().equals(obj1.toString()));
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    public static String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public static String convertDateTimestampToString(Date date) {
        if (notNull(date))
            return AppConstant.SIMPLE_TIMESTAMP_FORMAT.format(date);
        return "";
    }

    public static String convertDateMonthToString(Date date) {
        if (notNull(date))
            return AppConstant.SIMPLE_MONTH_FORMAT.format(date);
        return "";
    }

    public static Date convertStringToDate(String date) throws ParseException {
        if (isNotNullOrEmpty(date))
            return AppConstant.SIMPLE_DATE_FORMAT.parse(date);
        return null;
    }

    public static Date convertStringMonthToDate(String date) throws ParseException {
        if (isNotNullOrEmpty(date))
            return AppConstant.SIMPLE_MONTH_FORMAT.parse(date);
        return null;
    }

    public static String convertDateToString(Date date) {
        if (notNull(date))
            return AppConstant.SIMPLE_DATE_FORMAT.format(date);
        return "";
    }

    public static boolean isTrue(Integer value) {
        return isNotNullOrZero(value) ? Boolean.TRUE : Boolean.FALSE;
    }

    public static boolean isTrue(Long value) {
        return isNotNullOrZero(value) ? Boolean.TRUE : Boolean.FALSE;
    }
}
