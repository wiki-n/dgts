package crawler.dgts.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class NumberFormatVN {
	 public static String formatNumbertoStringVN(Object number) {
		 DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		    decimalFormatSymbols.setDecimalSeparator(',');
		    decimalFormatSymbols.setGroupingSeparator('.');
		    DecimalFormat decimalFormat = new DecimalFormat("#,###.#####", decimalFormatSymbols);
		    String kq=decimalFormat.format(number);
	 	    return kq;
    }
}
