package crawler.dgts.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;

@Slf4j
public class CurrencyFormatUtils {
    public static final String WITHOUT_DECIMAL_PLACES = "###,###,###";
    public static final String WITH_2_DECIMAL_PLACES = "###,###,###.##";
    public static final String WITH_3_DECIMAL_PLACES = "###,###,###.###";
    private static final char COMMA = ',';
    private static final char DOT = '.';
	private final static String ZERO = "không";
	private final static String ONE = "một";
	private final static String TWO = "hai";
	private final static String THREE = "ba";
	private final static String FOUR = "bốn";
	private final static String FIVE = "năm";
	private final static String SIX = "sáu";
	private final static String SEVEN = "bảy";
	private final static String EIGHT = "tám";
	private final static String NICE = "chín";
	private final static String TEN = "mười ";
	private final static String DONG = "đồng";
	private final static String TENS = "mươi";
	private final static String HUNDRED = "trăm";
	private final static String MILLIONS = "triệu";
	private final static String THOUSAN = "nghìn";
	private final static String BILLION = "tỷ";
	private final static String ONE2 = "mốt ";
	private final static String OLD = "lẻ ";
	private static final HashMap<String, String> hmTien = new HashMap<String, String>();
	private static HashMap<String, String> hmHanh = new HashMap<String, String>();
    private CurrencyFormatUtils() {
        throw new IllegalStateException("Utility class");
      }

    static {
        {
        	hmTien.put("0", ZERO);
        	hmTien.put("1", ONE);
        	hmTien.put("2", TWO);
        	hmTien.put("3", THREE);
        	hmTien.put("4", FOUR);
        	hmTien.put("5", FIVE);
        	hmTien.put("6", SIX);
        	hmTien.put("7", SEVEN);
        	hmTien.put("8", EIGHT);
        	hmTien.put("9", NICE);
        }
    };
    static {
        {
        	hmHanh.put("1", DONG);
        	hmHanh.put("2", TENS);
        	hmHanh.put("3", HUNDRED);
        	hmHanh.put("4", THOUSAN);
        	hmHanh.put("5", TENS);
        	hmHanh.put("6", HUNDRED);
        	hmHanh.put("7", MILLIONS);
        	hmHanh.put("8", TENS);
        	hmHanh.put("9", HUNDRED);
        	hmHanh.put("10", BILLION);
        	hmHanh.put("11", TENS);
        	hmHanh.put("12", HUNDRED);
        	hmHanh.put("13", THOUSAN);
        	hmHanh.put("14", TENS);
        	hmHanh.put("15", HUNDRED);

        }
    };

    public static String convertNumberToVNWords(String x) {
        String kq = "";
        x = x.replace(".", "");
        String[] arr_temp = x.split(",");
        if (!NumberUtils.isNumber(arr_temp[0])) {
            return "";
        }
        String m = arr_temp[0];
        int dem = m.length();
        String dau = "";
        int flag10 = 1;
        while (!m.equals("")) {
            if (m.length() <= 3 && m.length() > 1 && Long.parseLong(m) == 0) {

            } else {
                dau = m.substring(0, 1);
                if (dem % 3 == 1 && m.startsWith("1") && flag10 == 0) {
                    kq += ONE2;
                    flag10 = 0;
                } else if (dem % 3 == 2 && m.startsWith("1")) {
                    kq += TEN;
                    flag10 = 1;
                } else if (dem % 3 == 2 && m.startsWith("0") && m.length() >= 2 && !m.substring(1, 2).equals("0")) {
                    //System.out.println("a  "+m.substring(1, 2));
                    kq += OLD;
                    flag10 = 1;
                } else {
                    if (!m.startsWith("0")) {
                        kq += hmTien.get(dau) + " ";
                        flag10 = 0;
                    }
                }
                if (dem%3!=1 &&m.startsWith("0") && m.length()>1) {
                } else {
                    if (dem % 3 == 2 && (m.startsWith("1") || m.startsWith("0"))) {//mười
                    } else {
                        kq += hmHanh.get(dem + "") + " ";
                    }
                }
            }
            m = m.substring(1);
            dem = m.length();
        }
        kq=kq.substring(0, kq.length() - 1);
        return kq;
    }

    public static String formatWithoutDecimalPlaces(String curr) {
        return currencyFormat( curr, WITHOUT_DECIMAL_PLACES, DOT);
    }

    public static String currencyFormatWith2DecimalPlaces(String curr) {
        return currencyFormat( curr, WITH_2_DECIMAL_PLACES, DOT);
    }

    public static String currencyFormatWith3DecimalPlaces(String curr) {
        return currencyFormat( curr, WITH_3_DECIMAL_PLACES, COMMA);
    }

    public static String currencyFormatWith3DecimalPlacesComma(String curr) {
        return decimalNumberFormat( curr, WITH_3_DECIMAL_PLACES);
    }
    public static String currencyFormatWith2DecimalPlacesComma(String curr) {
        return decimalNumberFormat( curr, WITH_2_DECIMAL_PLACES);
    }
    
    public static String formatWithoutDecimalPlacesWithComma(String curr) {
        return currencyFormat( curr, WITHOUT_DECIMAL_PLACES, COMMA);
    }

    public static String currencyFormat(String curr, final String pattern, char comma) {
        try {
            BigDecimal bigDecimal = new BigDecimal(curr);
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setGroupingSeparator(comma);
            DecimalFormat numFormat = new DecimalFormat(pattern, symbols);
            return numFormat.format(bigDecimal);
        } catch (NumberFormatException e) {
        	log.error("CurrencyFormatUtils : ", e.toString());
        }
		return "";
	}
    
    public static String decimalNumberFormat(String curr, final String pattern) {
        try {
            BigDecimal bigDecimal = new BigDecimal(curr);

            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setGroupingSeparator(DOT);
            symbols.setDecimalSeparator(COMMA);
            DecimalFormat numFormat = new DecimalFormat(pattern, symbols);
            return numFormat.format(bigDecimal);
        } catch (NumberFormatException e) {
        	log.error("CurrencyFormatUtils : ", e.toString());
        }
		return "";
	}


}
