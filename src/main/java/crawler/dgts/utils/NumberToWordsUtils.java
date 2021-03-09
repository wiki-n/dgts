package crawler.dgts.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.TreeMap;

public class NumberToWordsUtils {
	private final static TreeMap<Integer, String> mapNumberRoman = new TreeMap<Integer, String>();
	private final static String ZERO = "không";
	private final static String ONE = "một";
	private final static String ONE2 = "mốt";
	private final static String TWO = "hai";
	private final static String THREE = "ba";
	private final static String FOUR = "bốn";
	private final static String FIVE = "năm";
	private final static String SIX = "sáu";
	private final static String SEVEN = "bảy";
	private final static String EIGHT = "tám";
	private final static String NICE = "chín";
	private final static String TEN = "mười";
	private final static String TENS = "mươi";
	private final static String HUNDRED = "trăm";
	private final static String MILLIONS = "triệu";
	private final static String THOUSAN = "nghìn";
	private final static String BILLION = "tỷ";
	private final static String OLD = "linh";
	private final static String FIFTH = "lăm";
	private final static String COMMA = "phẩy";
	private final static String SPACE = " ";
	private static final char DOT = '.';
	private final static String[] sPo = { "", THOUSAN + SPACE, MILLIONS + SPACE, BILLION + SPACE, THOUSAN + SPACE,
			MILLIONS + SPACE, BILLION + SPACE };
	private final static String[] sSo = { ZERO + SPACE, ONE + SPACE, TWO + SPACE, THREE + SPACE, FOUR + SPACE,
			FIVE + SPACE, SIX + SPACE, SEVEN + SPACE, EIGHT + SPACE, NICE + SPACE };
	private final static String[] sDonvi = { "", TENS + SPACE, HUNDRED + SPACE };
	static {
		mapNumberRoman.put(1000, "M");
		mapNumberRoman.put(900, "CM");
		mapNumberRoman.put(500, "D");
		mapNumberRoman.put(400, "CD");
		mapNumberRoman.put(100, "C");
		mapNumberRoman.put(90, "XC");
		mapNumberRoman.put(50, "L");
		mapNumberRoman.put(40, "XL");
		mapNumberRoman.put(10, "X");
		mapNumberRoman.put(9, "IX");
		mapNumberRoman.put(8, "VIII");
		mapNumberRoman.put(7, "VII");
		mapNumberRoman.put(6, "VI");
		mapNumberRoman.put(5, "V");
		mapNumberRoman.put(4, "IV");
		mapNumberRoman.put(3, "III");
		mapNumberRoman.put(2, "II");
		mapNumberRoman.put(1, "I");

	}

	public final static String toRoman(int number) {
		int l = mapNumberRoman.floorKey(number);
		if (number == l) {
			return mapNumberRoman.get(number);
		}
		return mapNumberRoman.get(l) + toRoman(number - l);
	}

	/*public final static Integer romanToNumber(String romanNumber) {
		for (java.util.Map.Entry<Integer, String> entry : mapNumberRoman.entrySet()) {
			if (Objects.equals(romanNumber, entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

	  public static void main(String[] args) {

	  BigInteger tongtien = BigDecimal.valueOf(4890410958904L).toBigInteger();

	  String value = numberToString(tongtien); System.out.println(value);


	  BigDecimal rate = BigDecimal.valueOf(0.5);
	  *//*System.out.println(convertRateToWords(rate)); rate =
	  BigDecimal.valueOf(0.50); System.out.println(convertRateToWords(rate)); rate
	  = BigDecimal.valueOf(0.05); System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(5.21);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(0.500);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(18.01);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(1.11);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(1.21);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(1.1); System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(1.5); System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(5.1); System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(5.05);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(15.05);
	  System.out.println(convertRateToWords(rate)); rate =
	  BigDecimal.valueOf(15.15); System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(15.1);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(5.5); System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(5.01);
	  System.out.println(convertRateToWords(rate)); rate =
	  BigDecimal.valueOf(8.55); System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(8.10);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(10.0);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(10.10);
	  System.out.println(convertRateToWords(rate)); rate =
	  BigDecimal.valueOf(10.01); System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(10.15);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(0.101);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(790.169);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(1790.169);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(11790.169);
	  System.out.println(convertRateToWords(rate));*//*

	  rate = BigDecimal.valueOf(10.34566);
	  System.out.println("TEST>> " + convertRate5DecimalToWords(rate));
*//*
	  System.out.println(convertRateToWords("111790000000000.169"));
	  System.out.println(convertRateToWords("111791234567891.169"));
	  System.out.println(convertRateToWords("1111791234567891.169"));
	  System.out.println(convertRateToWords("1541111791234567891.169")); rate =
	  BigDecimal.valueOf(0.121); System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(0.205);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(0.215);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(0.255);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(0.005);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(0.015);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(1.005);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(5.005);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(15.005);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(10.005);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(29.005);
	  System.out.println(convertRateToWords(rate));

	  rate = BigDecimal.valueOf(36.001);
	  System.out.println(convertRateToWords(rate)); *//*
	  while(true) { try{
	  BufferedReader bufferRead = new BufferedReader(new
	  InputStreamReader(System.in)); String s = bufferRead.readLine(); rate = new
	  BigDecimal(s); System.out.println(convertRateToWords(rate)); }
	  catch(IOException e) { e.printStackTrace(); break; } }


	  }*/
	public static String formatNumberForRead(BigInteger number) {
		NumberFormat nf = NumberFormat.getInstance();
		String temp = nf.format(number);
		String strReturn = "";
		int slen = temp.length();
		for (int i = 0; i < slen; i++) {
			if (String.valueOf(temp.charAt(i)).equals("."))
				break;
			else if (Character.isDigit(temp.charAt(i))) {
				strReturn += String.valueOf(temp.charAt(i));
			}
		}
		return strReturn;

	}

	public static String convertRateToWords(BigDecimal number) {
		String sNumber = number.toString();
		return convertRateToWords(sNumber);
	}

	public static String convertRate5DecimalToWords(BigDecimal number) {
		String sNumber = number.toString();
		if (StringUtils.isEmpty(sNumber))
			return "";
		sNumber = sNumber.contains(".") ? sNumber.replaceAll("0*$", "") : sNumber;
		String[] sNumberArr = sNumber.split("\\.");
		String firstNumber = convertRateToWords(sNumberArr[0]);
		StringBuilder result = new StringBuilder();
		if ("0".equalsIgnoreCase(sNumberArr[0])){
			firstNumber = ZERO;
		}
		result.append(firstNumber);
		String secondNumber = "";
		if (sNumberArr.length ==2) {
			result.append(" phẩy ");
		//	secondNumber = numberToString(sNumberArr[1]);
			if(sNumberArr[1].length()>5) {
				sNumberArr[1] = sNumberArr[1].substring(0,5);
			}
			secondNumber= Read5Decimal(sNumberArr[1]);
		
		
			result.append(secondNumber);
		}
		return result.toString();
	}

	public static String Read5Decimal(String number) {
		if (number == null) {
			return "";
		}
		String newNumber = "1" + number;
		String newNumberWord = numberToString(newNumber);
		int lengthNewNumber = number.length();
		switch (lengthNewNumber) {
		case 1:
			return numberToString(number);
		case 2: {
			String result = newNumberWord.substring(9);
			return result.replace(OLD, ZERO);
		}
		case 3: {
			if (number.startsWith("00")) {
				return ZERO + SPACE + HUNDRED + SPACE + newNumberWord.substring(10);
			}
			return newNumberWord.substring(10);
		}
		case 4:
			return readDecimalWith4Number(number, newNumberWord);

		case 5:
			return readDecimalWith5Number(number, newNumberWord);
		
	   default:
			return "";
	   }
		
	}

	public static String readDecimalWith4Number(String number, String newNumberWord) {
		String dovi = numberToString("1" + number.substring(1));
		if (number.startsWith("000")) {
			return ZERO + SPACE + THOUSAN + SPACE + ZERO + SPACE + HUNDRED + newNumberWord.substring(10);
		}
		if (number.startsWith("0")) {
			return ZERO + SPACE + sPo[1] + dovi.substring(10);
		}
		if (checkStartsWith(number,"00",1)) {
			String thousand = number.substring(0, 1);
			return numberToString(thousand) + SPACE + sPo[1] + ZERO + SPACE + HUNDRED + SPACE + dovi.substring(10);
		}
		String thousand = number.substring(0, 1);
		return numberToString(thousand) + SPACE + sPo[1] + dovi.substring(10);

	}

	public static String readDecimalWith5Number(String number, String newNumberWord) {
		String dovi = numberToString("1" + number.substring(2));
		if (number.startsWith("0000")) {
			return ZERO + SPACE + ZERO + SPACE + sPo[1] + ZERO + SPACE + HUNDRED + SPACE + dovi.substring(10);
		}
		if (number.startsWith("00")) {
			return ZERO + SPACE + ZERO + SPACE + sPo[1] + dovi.substring(10);
		}
		if (number.startsWith("0")) {
			if (checkStartsWith(number,"00",2)) {
				String thousand = number.substring(1, 2);
				return ZERO + SPACE + numberToString(thousand) + SPACE + sPo[1] + ZERO + SPACE + HUNDRED + SPACE
						+ dovi.substring(10);
			}
			String result = newNumberWord.substring(9);
			return result.replaceFirst(OLD, ZERO);
		}
		if (checkStartsWith(number,"00",2)) {
			String thousand = number.substring(0, 2);
			return numberToString(thousand) + SPACE + sPo[1] + ZERO + SPACE + HUNDRED + SPACE
					+ dovi.substring(10);
		}
		return newNumberWord.substring(9);

	}
	public static boolean checkStartsWith(String number,String start,int index) {
		String a= number.substring(index);
		if(a.startsWith(start)) {
			return true;
		}else {
			return false;
		}
	}
	public static String convertRateToWords(String sNumber) {
		if (StringUtils.isEmpty(sNumber))
			return "";
		String result = "";
		sNumber = sNumber.contains(".") ? sNumber.replaceAll("0*$", "") : sNumber;
		String[] sNumberArr = sNumber.split("\\.");

		int sNumberArrLength = sNumberArr.length;
		if (sNumberArrLength > 1) {
			boolean isZeroNumber = StringUtils.isNotBlank(sNumberArr[1]) && (Integer.valueOf(sNumberArr[1]) == 0);
			if (isZeroNumber) {
				return numberToString(new BigDecimal(sNumber));
			}
			String wholeNumber = sNumberArr[0];
			String decimalNumber = sNumberArr[1];
			String wholeNumberWord = numberToString(new BigDecimal(wholeNumber));
			String decimalNumberWord = "";
			// Lat nguoc chuoi nay lai
			String sNumber1 = "0." + decimalNumber;
			int iLen = sNumber1.length();
			// Lat nguoc chuoi nay lai
			String sNumber2 = "";
			for (int i = iLen - 1; i >= 0; i--) {
				sNumber2 += sNumber1.charAt(i);
			}

			// iLen = 4;
			// Tao mot vong lap de doc so
			// Tao mot bien nho vi tri cua sNumber
			int iRe = 0;
			// Tao mot bien cat tam
			String sCut = sNumber2.substring((iRe * iLen), (iRe * iLen) + iLen);
			decimalNumberWord = ReadDecimal(sCut, iRe) + "";
			result = StringUtils.isBlank(wholeNumberWord) ? decimalNumberWord
					: wholeNumberWord + decimalNumberWord.replaceFirst(ZERO, "");
		} else {
			result = numberToString(new BigDecimal(sNumberArr[0]));
		}

		return result.trim();
	}

	public static String numberToString(BigDecimal number) {
		return numberToString(number.toBigInteger());
	}

	public static String numberToString(BigInteger number) {
		String sNumber = number.toString();
		return numberToString(sNumber);
	}

	public static String numberToString(String sNumber) {
		// Tao mot bien tra ve
		String sReturn = "";
		// Tim chieu dai cua chuoi
		int iLen = sNumber.length();
		// Lat nguoc chuoi nay lai
		String sNumber1 = "";
		for (int i = iLen - 1; i >= 0; i--) {
			sNumber1 += sNumber.charAt(i);
		}
		// Tao mot vong lap de doc so
		// Tao mot bien nho vi tri cua sNumber
		int iRe = 0;
		do {
			// Tao mot bien cat tam
			String sCut = "";
			if (iLen > 3) {
				sCut = sNumber1.substring((iRe * 3), (iRe * 3) + 3);
				sReturn = Read(sCut, iRe) + sReturn;
				iRe++;
				iLen -= 3;
			} else {
				sCut = sNumber1.substring((iRe * 3), (iRe * 3) + iLen);
				sReturn = Read(sCut, iRe) + sReturn;
				break;
			}
		} while (true);

		// xu ly lan cuoi voi 220 000 tỷ 000 000 000 000 000
		if (sNumber.length() > 12) {
			// tren gia tri can xu ly, kiem tra xem don vi TY co = 000 khong
			int begin = sNumber.length() - 9;
			String donviTy = sNumber.substring(begin - 3, (begin - 3) + 3);
			if (donviTy.equals("000")) {
				sReturn = sReturn.replaceFirst(THOUSAN, THOUSAN + SPACE + BILLION);
			}
		}
		return sReturn.trim();
	}

	// Khoi tao ham Read
	public static String Read(String sNumber, int iPo) {
		// Tao mot bien tra ve
		String sReturn = "";
		// Tao mot bien so

		// Tim chieu dai cua chuoi
		int iLen = sNumber.length();
		// Tao mot bien nho vi tri doc
		int iRe = 0;
		// Tao mot vong lap de doc so
		for (int i = 0; i < iLen; i++) {
			String sTemp = "" + sNumber.charAt(i);
			int iTemp = Integer.parseInt(sTemp);
			// Tao mot bien ket qua
			String sRead = "";
			// Kiem tra xem so nhan vao co = 0 hay ko
			if (iTemp == 0) {
				switch (iRe) {
				case 0:
					break;// Khong lam gi ca
				case 1: {
					if (sNumber.charAt(0) != '0') {
						sRead = OLD + SPACE;
					}
					break;
				}
				case 2: {
					if (sNumber.charAt(0) != '0' && sNumber.charAt(1) != '0') {
						sRead = ZERO + SPACE + HUNDRED + SPACE;
					}
					break;
				}
				}
			} else if (iTemp == 1) {
				switch (iRe) {
				case 0:
					sRead = ONE + SPACE;
					if ((sNumber.charAt(0) == '1') && (iLen > 1) && (sNumber.charAt(1) != '0')
							&& (sNumber.charAt(1) != '1')) {
						sRead = ONE2 + SPACE;
					}
					break;
				case 1:
					sRead = TEN + SPACE;
					break;
				default:
					sRead = ONE + SPACE + sDonvi[iRe];
					break;
				}
			} else if (iTemp == 5) {
				switch (iRe) {
				case 0: {
					if (sNumber.length() <= 1) {
						sRead = FIVE + SPACE;
					} else if (sNumber.charAt(1) != '0') {
						sRead = FIFTH + SPACE;
					} else {
						sRead = FIVE + SPACE;
					}
					break;
				}
				default:
					sRead = sSo[iTemp] + sDonvi[iRe];
				}
			} else {
				sRead = sSo[iTemp] + sDonvi[iRe];
			}

			sReturn = sRead + sReturn;
			iRe++;
		}
		if (sReturn.length() > 0) {
			sReturn += sPo[iPo];
		}
		// xu ly lan cuoi voi 220 000 tỷ 000 000 000 000 000
//		if (sNumber.length() > 12) {
//			// tren gia tri can xu ly, kiem tra xem don vi TY co = 000 khong
//			sNumber.substring(11, 8);
//		}
		return sReturn;
	}

	public static String ReadDecimal(String sNumber, int iPo) {
		// Tao mot bien tra ve
		String sReturn = "";
		// Tim chieu dai cua chuoi
		int iLen = sNumber.length();
		// Tao mot bien nho vi tri doc
		int iRe = 0;
		int currentIndex = 0;
		// Tao mot vong lap de doc so
		int decimalPo = sNumber.indexOf(DOT);
		for (int i = 0; i < iLen; i++) {
			String sTemp = "" + sNumber.charAt(i);
			String sRead = "";

			if (sTemp.indexOf(DOT) != -1) {
				sRead = COMMA + SPACE;
				sReturn = sRead + sReturn;
				iRe = 0;
				currentIndex++;
				continue;
			}
			int iTemp = Integer.parseInt(sTemp);

			// Tao mot bien ket qua
			// Kiem tra xem so nhan vao co = 0 hay ko
			if (iTemp == 0) {
				switch (iRe) {
				case 0:
					if (i == iLen - 1) {
						sRead = ZERO + " ";
					}
					break;// Khong lam gi ca
				case 1: {
					if (sNumber.charAt(0) != '0') {
						if (sNumber.length() >= 4 && sNumber.charAt(3) == DOT) {
							sRead = OLD + SPACE;
						} else {
							sRead = ZERO + " ";
						}
					}
					break;
				}
				case 2: {
					if (sNumber.charAt(0) != '0') {
						sRead = ZERO + SPACE + HUNDRED + SPACE;
					}
					break;
				}
				default:
					break;
				}
			} else if (iTemp == 1) {
				switch (iRe) {
				case 0:
					sRead = ONE + SPACE;
					if ((sNumber.length() >= 3 && sNumber.charAt(2) == DOT)
							|| (sNumber.length() >= 4 && sNumber.charAt(3) == DOT)) {
						if ((sNumber.charAt(0) == '1') && (sNumber.charAt(1) != '0') && (sNumber.charAt(1) != '1')
								&& (currentIndex != 3)) {
							sRead = ONE2 + SPACE;
						} else {

						}
					}
					break;
				case 1:
					sRead = TEN + SPACE;
					break;
				default:
					sRead = ONE + SPACE + sDonvi[iRe];
					break;
				}
			} else if (iTemp == 5) {
				switch (iRe) {
				case 0: {
					if ((sNumber.length() == 1) || ((sNumber.charAt(1) == DOT) && currentIndex == 0)
							|| ((sNumber.length() == 3) && currentIndex == 2)
							|| ((sNumber.length() == 4) && currentIndex == 3)
							|| ((((sNumber.length() == 3) && (sNumber.charAt(2) == DOT))
									|| (sNumber.length() == 4 && sNumber.charAt(3) == DOT)) && currentIndex == 0
									&& sNumber.charAt(1) == '0')) {
						sRead = FIVE + SPACE;
					} else if (((((sNumber.length() == 3) && (sNumber.charAt(2) == DOT))
							|| (sNumber.length() == 4 && sNumber.charAt(3) == DOT)) && currentIndex == 0
							&& sNumber.charAt(1) != 0) || (sNumber.length() == 5 && currentIndex == 3)
							|| (sNumber.length() == 6 && currentIndex == 4)
							|| (sNumber.length() == 4 && (sNumber.charAt(1) == DOT) && currentIndex == 2)) {
						sRead = FIFTH + SPACE;
					} else {
						sRead = FIVE + SPACE;
					} // 50.5
						// 50.51//21.5/1.51
					break;
				}
				default:
					sRead = sSo[iTemp] + sDonvi[iRe];
				}
			} else {
				sRead = sSo[iTemp] + sDonvi[iRe];
			}

			sReturn = sRead + sReturn;
			iRe++;
			currentIndex++;
		}
		if (sReturn.length() > 0) {
			sReturn += sPo[iPo];
		}

		return sReturn;
	}

	public static BigDecimal convertFloatToBigDecimal(Float value) {
		if (value == null)
			return BigDecimal.ZERO;
		BigDecimal bigValue = BigDecimal.valueOf(value).setScale(2, BigDecimal.ROUND_HALF_UP);
		return bigValue;
	}

	public static BigDecimal convertFloatToBigDecimal3Decimal(Float value) {
		if (value == null)
			return BigDecimal.ZERO;
		BigDecimal bigValue = BigDecimal.valueOf(value).setScale(3, BigDecimal.ROUND_HALF_UP);
		return bigValue;
	}

	public static String convertFloatToString(Float value) {
		if (value == null)
			return "";
		NumberFormat nf = NumberFormat.getInstance(new Locale("da", "DK"));
		BigDecimal bigValue = BigDecimal.valueOf(value).setScale(2, BigDecimal.ROUND_HALF_UP);
		return nf.format(bigValue);
	}

	public static String repeat(String s, int n) {
		if (s == null) {
			return null;
		}
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(s);
		}
		return sb.toString();
	}
}
