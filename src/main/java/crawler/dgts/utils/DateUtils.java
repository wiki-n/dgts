package crawler.dgts.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public final static String DD_MM_YYYY_1 =  "dd/MM/yyyy";
    public final static String DD_MM_YYYY_2 =  "dd-MM-yyyy";
    public final static String YYYY_MM_DD =  "yyyy-MM-dd";
    public final static String MM_YYYY =  "MM/yyyy";
    public final static String INVALID_DATE =  "Invalid Date";
    /*public static void main(String... arsg){
        String dd = getDD("10/02/2020", DD_MM_YYYY_1);
        System.out.println(dd);
    }*/

    public static String formatDDMMYYYY1(String dateInput, String dateInputPattern){
        try {
            return format(dateInput, dateInputPattern, DD_MM_YYYY_1);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getYYYY(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.YEAR));
    }

    public static int getMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return (calendar.get(Calendar.MONTH) + 1);
    }

    public static String getYYYY(String dateInput, String dateInputPattern){
        if((null == dateInput) || ("".equalsIgnoreCase(dateInput))){
            return null;
        }

        SimpleDateFormat formatterIn = new SimpleDateFormat(dateInputPattern);
        try {
            Date date1=formatterIn.parse(dateInput);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            return String.valueOf(calendar.get(Calendar.YEAR));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMM(String dateInput, String dateInputPattern){
        if((null == dateInput) || ("".equalsIgnoreCase(dateInput))){
            return null;
        }

        SimpleDateFormat formatterIn = new SimpleDateFormat(dateInputPattern);
        try {
            Date date1=formatterIn.parse(dateInput);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            int month = (calendar.get(Calendar.MONTH) + 1);
            return StringUtils.leftPad(String.valueOf(month), 2, "0");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDD(String dateInput, String dateInputPattern){
        if((null == dateInput) || ("".equalsIgnoreCase(dateInput))){
            return null;
        }

        SimpleDateFormat formatterIn = new SimpleDateFormat(dateInputPattern);
        try {
            Date date1=formatterIn.parse(dateInput);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            return String.valueOf(calendar.get(Calendar.DATE));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String format(String dateInput, String dateInputPattern, String dateOutputPattern) throws ParseException {
        if((null == dateInput) || ("".equalsIgnoreCase(dateInput))){
            return null;
        }

        SimpleDateFormat formatterIn = new SimpleDateFormat(dateInputPattern);
        SimpleDateFormat formatterOut = new SimpleDateFormat(dateOutputPattern);
        try {
            Date date1=formatterIn.parse(dateInput);
            return formatterOut.format(date1);
        } catch (ParseException e) {
            throw e;
        }
    }
    
    public static String getQuarterByMonth(int month){
        if (month < 4)
            return "I";
        if (month < 7)
            return "II";
        if (month < 10)
            return "III";

        return "IV";
    }

    public static int getQuarterNumberByMonth(int month){
        if (month < 4)
            return 1;
        if (month < 7)
            return 2;
        if (month < 10)
            return 3;

        return 4;
    }
    public static boolean isValidateDateFormat(String validateDateString, String fommatter) {
    	if(StringUtils.isEmpty(fommatter) || StringUtils.isEmpty(validateDateString)) {
    		return false;
    	}
        DateFormat sdf = new SimpleDateFormat(fommatter);
        sdf.setLenient(false);
        try {
            sdf.parse(validateDateString);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static String formatDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DD_MM_YYYY_1);
        SimpleDateFormat sdf2 = new SimpleDateFormat(YYYY_MM_DD);
        return sdf2.format(sdf.parse(date));
    }

    public static String formatDate(String date, String dateInputPattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(dateInputPattern);
        SimpleDateFormat sdf2 = new SimpleDateFormat(YYYY_MM_DD);
        return sdf2.format(sdf.parse(date));
    }

    public static boolean isThisDateValid(String dateToValidate, String dateFromat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateToValidate);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static String formatDateDDMMYYYY(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        SimpleDateFormat sdf2 = new SimpleDateFormat(DD_MM_YYYY_1);
        return sdf2.format(sdf.parse(date));
    }
}
