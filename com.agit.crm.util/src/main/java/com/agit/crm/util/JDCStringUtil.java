package com.agit.crm.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author bayutridewanto
 */
public class JDCStringUtil {

    private static final String PATTERN_DATE = "dd-MMM-yyy HH:mm:ss";
    private static final AtomicReference<Long> currentTime = new AtomicReference<>(System.currentTimeMillis());

    /**
     * Check Object null or not
     *
     * @param o
     * @return
     */
    public static boolean hasValue(Object o) {
        if (o == null) {
            return false;
        } else if (o.toString().trim().equals("")) {
            return false;
        } else if (o.toString().isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Concatenation String and String
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String concat(String s1, String s2) {
        return s1.concat(s2);
    }

    /**
     * Concatenation String and Date
     *
     * @param s1
     * @param d1
     * @return
     */
    public static String concatDate(String s1, Date d1) {
        return concatDate(s1, d1, PATTERN_DATE);
    }

    /**
     * Concatenation String and Date
     *
     * @param s1
     * @param d1
     * @param datePattern
     * @return
     */
    public static String concatDate(String s1, Date d1, String datePattern) {
        return s1.concat(DateUtil.dateToString(d1, datePattern));
    }

    public String defaultString(String a) {
        return a.trim().toLowerCase();
    }

    /**
     * Convert String to double
     *
     * @param s
     * @return
     */
    public static double toDouble(String s) {
        return Double.parseDouble(s.trim());
    }

    /**
     * Convert String to integer
     *
     * @param s
     * @return
     */
    public static int toInteger(String s) {
        return Integer.parseInt(s.trim());
    }

    /**
     * Convert String to long
     *
     * @param s
     * @return long
     */
    public static long toLong(String s) {
        return Long.parseLong(s.trim());
    }

    /**
     * Wrap given String with '%' in the beginning and end of it
     *
     * @param s
     * @return String
     */
    public static String wrappedByWildCard(String s) {
        String wildCard = "%";
        if (JDCStringUtil.hasValue(s)) {
            return wildCard + s + wildCard;
        }
        return wildCard;
    }

    /**
     * Constant signifying left
     */
    public static final int LEFT = 0;

    /**
     * Constant signifying right
     */
    public static final int RIGHT = 1;

    /**
     * Method to format a String that contain a double value so that the double
     * value represented has a fraction of maximum 8 digits If the double value
     * is actually a negative value then the returned value will be a String
     * bracing the formatted value without the - sign ( eg.
     * formatNumber("-5.4",1) will be return "(5.4)" )
     *
     * @param num A String whose value represent a double value
     * @return A formatted string whose value represent a double value
     */
    public static String formatNumber(String num) {
        return formatNumber(num, 8, 0);
    }

    /**
     * Method to format a String that contain a double value so that the double
     * value represented has a fraction of <code>precision</code> If the double
     * value is actually a negative value then the returned value will be a
     * String bracing the formatted value without the - sign ( eg.
     * formatNumber("-5.4",1) will be return "(5.4)" )
     *
     * @param num A String whose value represent a double value
     * @param precision Fraction Digits
     * @return A formatted string whose value represent a double value
     */
    public static String formatNumber(String num, int precision) {
        return formatNumber(num, precision, precision);
    }

    /**
     * Method to format a String that contain a double value so that the double
     * value represented has a minimum fraction of <code>minPrecision</code> and
     * a maximum fraction of <code>precision</code> If the double value is
     * actually a negative value then the returned value will be a String
     * bracing the formatted value without the - sign ( eg.
     * formatNumber("-5.4",1,1) will be return "(5.4)" )
     *
     * @param num A String whose value represent a double value
     * @param precision Maximum Fraction Digits
     * @param minPrecision Minimum Fraction Digits
     * @return A formatted string whose value represent a double value
     */
    public static String formatNumber(String num, int precision, int minPrecision) {
        return formatNumber(num, precision, minPrecision, true);
    }

    public static String formatNumber(String num, int precision, int minPrecision, boolean useGrouping) {
        try {
            DecimalFormat nf = new DecimalFormat();

            nf.setMinimumFractionDigits(minPrecision);
            nf.setMaximumFractionDigits(precision);

            nf.setGroupingUsed(useGrouping);
            double dd = Double.parseDouble(num);

            if (dd < 0) {
                dd = dd * (-1); // make positive number
                num = "(" + nf.format(dd) + ")";
            } else {
                num = nf.format(dd);
            }
        } catch (Exception e) {
        }
        return num;
    }

    /**
     * Method fix the long format represented by the String value to the normal
     * format. If the String is null or an empty String the "" is returned
     *
     * @param value The String to parse
     * @return "" or a String with a correct long format.
     */
    public static String removeZeros(String value) {
        if (JDCStringUtil.hasValue(value)) {
            try {
                long tmp = Long.parseLong(value.trim());
                return "" + tmp;
            } catch (Exception e) {
                return value;
            }
        }
        return "";
    }

    /**
     * Behave exactly like String.substring(int start,int end) except if the
     * String is null it returns "" and if <code>len</code> exceed the String's
     * length the the whole String is returned
     *
     * @param str The String to be parsed
     * @param len The number of characters in the desired substring
     * @return A substring, or if the String is null then "" is returned. if
     * <code>len</code> exceed the String the the String will be returned.
     */
    public static String left(String str, int len) {
        if (str == null) {
            return "";
        }
        if (str.length() > len) {
            return str.substring(0, len);
        }
        return str;
    }

    /**
     * Method to return a substring from <code>str</code>. The substring cropped
     * starting from the end of the String to the beginning of the String as
     * much as <code>len</code>. So right("December",5) would return "ember". If
     * the String is null then "" is returned. if <code>len</code> exceed the
     * String the the String will be returned.
     *
     * @param str The String to be substring
     * @param len The number of characters in the desired substring
     * @return A substring, or if the String is null then "" is returned. if
     * <code>len</code> exceed the String the the String will be returned.
     */
    public static String right(String str, int len) {
        if (str == null) {
            return "";
        }
        if (str.length() > len) {
            return str.substring(str.length() - len, str.length());
        }
        return str;
    }

    /**
     *
     * Method To convert any string from Format ( <b>###,###.#### </b>) to (
     * <b>#######.#### </b>)
     *
     * @param number String
     * @return String
     */
    public static String reFormat(String number) {
        String answer = null;
        try {
            java.text.DecimalFormat a = new java.text.DecimalFormat();
            answer = (new java.math.BigDecimal(a.parse(number).toString())).toString();
        } catch (Exception e) {
            e.getMessage();
        }
        return answer;
    }

    /**
     * Method to replace "'" substring with the substring "''". SQL insert is
     * sensitive to word contain character '
     *
     * @param string The String to parse
     * @return Returns null if the String is null, returns a parsed String
     * otherwise
     */
    public static String escapeQuote4SQL(String string) {
        if (string != null) {
            return JDCStringUtil.replace(string, "'", "''");
        }
        return string;

    }

    /**
     * Tokenized a String (the tokens separator is specified in
     * <code>separator</code> parameter) and store the token values in a Vector.
     *
     * @param string2bTokenized The string to be parsed
     * @param separator The separator
     * @return The Vector containing the tokens
     * @version : 1.0
     */
    @SuppressWarnings("UseOfObsoleteCollectionType")
    public static Vector<String> tokenized(String string2bTokenized, String separator) {
        StringTokenizer tokens = new StringTokenizer(string2bTokenized, separator);
        Vector<String> vectorReturned = new Vector();
        int count = tokens.countTokens();
        for (int i = 0; i < count; i++) {
            String temp = tokens.nextToken().trim();
            vectorReturned.addElement(temp);
        }
        return vectorReturned;
    }

    /**
     * To convert a null, an empty String or a String whose value is "null" to
     * "". If the String does not match the criteria the String is returned in
     * verbatim.
     *
     * @param str The string to be parsed
     * @return The "" if <code>parameter</code> match the criteria or the String
     * in verbatim else wise
     */
    public static String nullStr(String str) {
        return nullStr(str, "");
    }

    /**
     * To convert a null, an empty String or a String whose value is "null" to
     * "". If the String does not match the criteria the String is returned in
     * verbatim.
     *
     * @param str The string to be parsed
     * @return The "" if <code>parameter</code> match the criteria or the String
     * in verbatim else wise
     */
    public static String nullString(String str) {
        return nullStr(str, "");
    }

    /**
     * Method to replace the "'" substring occurance with the substring "''"
     * from <code>str</code>. If the String is null, an empty String of a String
     * whose value is "null" then <code>defaultString</code> will be returned.
     *
     * @param str The String to be parsed
     * @param defaultString The replacement String if <code>parameter</code>
     * match the criteria
     * @return The parsed String
     */
    public static String nullStr2(String str, String defaultString) {
        return replace(nullStr(str, defaultString), "'", "''");
    }

    /**
     * Method to replace the "'" substring occurance with the substring "''"
     * from <code>str</code>. If the String is null, an empty String of a String
     * whose value is "null" then "" will be returned.
     *
     * @param str The String to be parsed
     * @return The parsed String
     */
    public static String nullStr2(String str) {
        return replace(nullStr(str, ""), "'", "''");
    }

    /**
     * To convert a null, an empty String or a String whose value is "null" to a
     * default string specified by <code>defaultString</code>. If the String
     * does not match the criteria the String is returned in verbatim.
     *
     * @param parameter The string to be parsed
     * @param defaultString The replacement String if <code>parameter</code>
     * match the criteria
     * @return The default String if <code>parameter</code> match the criteria
     * or the String in verbatim else wise
     * @version : 1.0
     */
    public static String nullStr(String parameter, String defaultString) {
        return (parameter == null || parameter.equalsIgnoreCase("") || parameter.equalsIgnoreCase("null")) ? defaultString : parameter;
    }

    /**
     * To convert a null String to "--"
     *
     * @param str The string to be parsed
     * @return "--" if the String is null
     * @version : 1.0
     */
    public static String nullStrDash(String str) {
        return nullStr(str, "--");
    }

    public static String nullObj(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    /**
     * To convert a null or an empty String to the default float value 0 (the
     * returned value is still a String object it just has the value "0"). If
     * the String is not null or empty, the the String is returned bluntly.
     *
     * @param str The string to be parsed
     * @return "0" if <code>str</code> is null or an empty String, or the String
     * in verbatim if <code>str</code> does not match the criteria.
     * @version : 1.0
     */
    public static String nullFloat(String str) {
        return (!JDCStringUtil.hasValue(str)) ? "0" : str;
    }

    /**
     * Return the Date information in a String. If <code>date</code> is
     * <code>null</code> the the returned String will consist of only "--"
     *
     * @param date The Date whose information is to be presented in String
     * @return The date information in String. Returns "--" if <code>date</code>
     * is <code>null</code>
     * @version : 1.0
     */
    public static String nullDate(Date date) {
        if (date == null) {
            return "--";
        }
        return date.toString();
    }

    /**
     * To identified if a string is null, an empty String or consisting of only
     * spaces
     *
     * @param str The string to check
     * @return true if @param str is null, an empty String or consisting of only
     * spaces, returns false otherwise
     * @version : 1.0
     */
    public static boolean isNullStr(String str) {
        return !JDCStringUtil.hasValue(str);
    }

    /**
     * To Pad a given String with a given char as much as specified by
     * <code>len</code> in the direction
     *
     * specified by <code>direction</code>
     *
     * @param str The String to be padded
     * @param len How many characters to pad <code>str</code>
     * @param c The character used to pad
     * @param direction The direction of pad, use <code>JDCStringUtil.LEFT</code>
     * to pad the String to the left and use <code>JDCStringUtil.RIGHT</code> to
     * pad the String to the right
     * @return The padded String
     * @version : 1.0
     */
    public static String pad(String str, int len, char c, int direction) {
        StringBuilder sb = new StringBuilder(str);
        if (direction == JDCStringUtil.LEFT) {
            sb.reverse();
            for (int i = str.length(); i < len; i++) {
                sb.append(c);
            }
            sb.reverse();
        } else {
            for (int i = str.length(); i < len; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * To Pad a given String with leading zeros, it will truncate if @param str
     * length exceed given length
     *
     * @param str The String to be padded
     * @param len How many characters to pad <code>str</code>
     * @return The padded String
     * @version : 1.0
     */
    public static String padZeros(String str, int len) {
        return (str.length() > len) ? str.substring(0, len) : pad(str, len, '0', JDCStringUtil.LEFT);
    }

    /**
     * To Pad a given String with tailing zeros, it will truncate if @param str
     * length exceed given length
     *
     * @param str The String to be padded
     * @param len How many characters to pad <code>str</code>
     * @return The padded String
     * @version : 1.0
     */
    public static String padZerosBack(String str, int len) {
        return (str.length() > len) ? str.substring(0, len) : pad(str, len, '0', JDCStringUtil.RIGHT);
    }

    /**
     * To Pad a given String with trailing space, it will truncate if @param str
     * length exceed given length
     *
     * @param str The String to be padded
     * @param len How many characters to pad <code>str</code>
     * @return The padded String
     * @version : 1.0
     */
    public static String padSpaceBack(String str, int len) {
        str = JDCStringUtil.nullStr(str);
        return (str.length() > len) ? str.substring(0, len) : pad(str, len, ' ', JDCStringUtil.RIGHT);
    }

    /**
     * To Pad a given String with leading space, it will truncate if @param str
     * length exceed given length
     *
     * @param str The String to be padded
     * @param len How many characters to pad <code>str</code>
     * @return The padded String
     * @version : 1.0
     */
    public static String padSpace(String str, int len) {
        str = JDCStringUtil.nullStr(str);
        return (str.length() > len) ? str.substring(0, len) : pad(str, len, ' ', JDCStringUtil.LEFT);
    }

    /*
     * public static String createRef(String base){ base = padZeros(base,11);
     * return base+getCheckDigit(base); }
     * 
     * public static String createDDA(String base, String fundHouse){ base =
     * padZeros(base,8); return fundHouse+base+getCheckDigit(base); } public
     * static boolean checkTransRefNo(String no2Check){ String chkDigit =
     * getCheckDigit(no2Check.substring(0,no2Check.length()-1)); return
     * chkDigit.equals(no2Check.substring(no2Check.length()-1)); }
     * 
     * private static String getCheckDigit(String myNumber) { int total = 0; int
     * one, two, multiply, d1, d2 ; int l= myNumber.length(); for (int i = 0; i
     * < l ;i++){ one = 0; one = Integer.parseInt(myNumber.substring(i,i+1));
     * two = 0; if (i+1 != l) { i++; two =
     * Integer.parseInt(myNumber.substring(i,i+1)); } multiply = two * 2; d1 =
     * 0; d2 = 0; if (multiply > 9) { d1 = multiply / 10; d2 = multiply % 10; }
     * else { d1 = multiply; } total += one + d1 + d2; } total = total % 10;
     * return ""+total; }
     */
    /**
     * To verify a given String is a floating point.
     *
     * @param str The string to be verified
     * @return true if the string is numeric
     * @version : 1.0
     */
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public static boolean isNumeric(String str) {
        try {
            new Double(nullFloat(str.trim()));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Replaces ONLY the first occurrence of a pattern found in a given String
     * with new pattern
     *
     * @param source The String whose characters are to be replaced
     * @param from The pattern to be replaced
     * @param to The new pattern to replace the old pattern
     * @return The String edited
     */
    public static String replace2(String source, String from, String to) {
        StringBuffer result = new StringBuffer();
        int i = source.indexOf(from, 0);
        if (i >= 0) {
            result.append(source.substring(0, i));
            result.append(to);
            i += from.length();
        } else {
            i = 0;
        }
        result.append(source.substring(i));
        return new String(result);
    }

//    public static String replace(String str,String regex, String replacement) {
//        return Pattern.compile(regex).matcher(str).replaceAll(replacement);
//    }
    /**
     * method to replace certain characters pattern at <code>str</code> given by
     * the <code>pattern</code> parameter with the characters pattern at
     * <code>replace</code>.
     *
     * @param str The String which certain parts of it will be replaced by the
     * given pattern.
     * @param pattern Characters pattern that will be replaced
     * @param replace Characters pattern that will be the replacement
     *
     * @return The String whose certain characters have been replaced by the
     * given pattern
     */
    public static String replace(String str, String pattern, String replace) {
        int s = 0;
        int e = 0;
        StringBuilder result = new StringBuilder();

        try {
            while ((e = str.indexOf(pattern, s)) >= 0) {
                result.append(str.substring(s, e));
                result.append(replace);
                s = e + pattern.length();
            }
            result.append(str.substring(s));
        } catch (Exception ee) {
        }
        return result.toString();
    }

    /**
     * Convert array to Vector
     *
     * @param array array to be converted
     * @return Vector The new array
     * @version : 1.0
     */
    @SuppressWarnings("UseOfObsoleteCollectionType")
    public static Vector<Object> array2Vector(Object[] array) {
        return new Vector(Arrays.asList(array));
    }

    /**
     * To extract the filename from dir + filename For unix and windows platform
     * only
     *
     * @param file full path filename ie: \\path\\C://test// very long file
     * withspace.txt
     * @return generated the filename extracted ie : return
     * very_long_file_withspace.txt
     * @version : 1.0 2001-06-27
     */
    public static String extractFilename(String file) {
        if (file.indexOf("/") == file.indexOf("\\")) {
            return file.replace(' ', '_');
        }
        int lastIndex = (file.lastIndexOf("\\") > file.lastIndexOf("/")) ? file.lastIndexOf("\\") : file.lastIndexOf("/");
        return file.substring(lastIndex + 1).replace(' ', '_');
    }

    /**
     * Get the servlet name minus the relative path
     *
     * @param o
     * @return absolute servlet name
     * @author : Ng Yong Boon
     * @version : 1.0 2001-07-.3
     */
    public static String getClassName(Object o) {
        String classname = o.getClass().toString();
        return classname.substring(classname.lastIndexOf(".") + 1);
    }

    /**
     * Helper method to replace every '*' character with '%' character in a
     * String object.
     *
     * @param criteria The String whose characters are likely to be replaced
     * @return String The String with every '*' replaced with '%'
     */
    public static String replaceWildcard(String criteria) {
        if (isNullStr(criteria)) {
            return null;
        }
        if (criteria.contains("*")) {
            criteria = criteria.replace('*', '%');
        } else {
            // criteria = ("%") + criteria + ("%");
            criteria = criteria + ("%");
        }
        return criteria;
    }

    public static final String lineWrap(String str, int borderLine) {
        char NEW_LINE = '\n';
        char SPACE = ' ';
        int strLength = str.length();

        if (strLength > borderLine) {
            String sub = str.substring(0, borderLine);
            String sub2 = str.substring(borderLine);

            int spaceIdx = str.lastIndexOf(SPACE);

            // get the index of righmost occurence of space char before
            // borderline
            int spaceIdxA = sub.lastIndexOf(SPACE);

            // get the index of leftmost occurrence of space char after
            // borderline
            int spaceIdxB = sub2.indexOf(SPACE);

            int diff = (borderLine - spaceIdxA) - 1;

            // space found not at beginning or not exist
            if (spaceIdx > 0) {
                // space found before borderline
                if ((spaceIdxA >= 0) & (spaceIdxB == -1)) {
                    return rTrim(str.substring(0, spaceIdxA))
                            + NEW_LINE
                            + lineWrap(str.substring(spaceIdxA).trim(), borderLine);
                } // space found after borderline
                else if ((spaceIdxB >= 0) & (spaceIdxA == -1)) {
                    return rTrim(str.substring(0, (borderLine + spaceIdxB)))
                            + NEW_LINE
                            + lineWrap(str.substring((borderLine + spaceIdxB)).trim(), borderLine);
                } // space found before & after borderline
                else if ((spaceIdxA >= 0) && (spaceIdxB >= 0)) {
                    if (diff <= spaceIdxB) {
                        return rTrim(str.substring(0, spaceIdxA))
                                + NEW_LINE
                                + lineWrap(str.substring(spaceIdxA).trim(), borderLine);
                    } else if (diff > spaceIdxB) {
                        return rTrim(str.substring(0, (borderLine + spaceIdxB)))
                                + NEW_LINE
                                + lineWrap(str.substring(
                                                (borderLine + spaceIdxB)).trim(), borderLine);
                    }
                }
            }
            // no space character found or at the beginning or found but not in the conditional
            return rTrim(str.substring(0, borderLine - 3))
                    + NEW_LINE
                    + lineWrap(str.substring((borderLine - 3)).trim(), borderLine);
        }
        return str;
    }

    public static String rTrim(String string) {
        String WHITESPACE_CHARS = " \t\n\f\r";
        if (string.length() == 0) {
            return string;
        }
        StringBuffer sb = new StringBuffer(string).reverse();
        while (WHITESPACE_CHARS.indexOf(sb.charAt(0)) >= 0) {
            sb.deleteCharAt(0);
        }
        return sb.reverse().toString();
    }

    public static String[] subString(String string, int numOfChar, int numOfString) {
        String[] stringArr = new String[numOfString];
        int length = string.length();
        int lengthRemain = 0;
        int beginIndex = 0;
        int endIndex = numOfChar - 1;
        int i = 0;
        boolean stop = false;

        while ((i < numOfString) && (!stop)) {
            if (length > numOfChar) {
                stringArr[i] = string.substring(beginIndex, endIndex);
                beginIndex = endIndex + 1;
                lengthRemain = length - ((i + 1) * numOfChar);
                if (lengthRemain > numOfChar) {
                    endIndex = endIndex + numOfChar;
                } else {
                    endIndex = endIndex + lengthRemain;
                }
                i++;
            } else {
                stringArr[i] = string;
                stop = true;
            }
        }

        return stringArr;
    }

    public static <T> T nvl(T arg0, T arg1) {
        return (arg0 == null) ? arg1 : arg0;
    }
    
    public static Integer getID() {
        Long prev;
        Long next = System.currentTimeMillis();
        do {
            prev = currentTime.get();
            next = next > prev ? next : prev + 1;
        } while (!currentTime.compareAndSet(prev, next));
        return next.intValue();
    }
}
