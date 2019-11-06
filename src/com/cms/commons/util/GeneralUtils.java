package com.cms.commons.util;


import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

public class GeneralUtils {

    //public static final String FORMAT_DATE_USA = "MM/dd/yyyy";
    public static final String FORMAT_DATE_USA = "yyyy-MM-dd HH:mm:ss";

    public static Calendar dateString2Calendar(String s) throws ParseException {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT0"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Date d1 = df.parse(s);
        cal.setTime(d1);
        return cal;
    }

    public static String dateCalendar2String(Calendar c) throws ParseException {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT0"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(c.getTime());
    }

    public static Calendar dateLong2Calendar(Long l) throws ParseException {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT0"));
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(l);
        return cal;
    }

    public static String date2String(Timestamp date, String format) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static String toText(Object object) {
        return toText(object, "\n", ":");
    }

    public static String toText(Object object, String fieldSeparator, String valueSeparator) {
        return toText(object, fieldSeparator, valueSeparator, true);
    }

    // PERMITIR PASAR EL PADDING (DEFAULT "  ") (OK)
    // PERMITIR PASAR SI ES RECURSIVO O NO (DEFAULT NO)
    // RECORRER LIST (OK, FALTA LISTA RECURSIVA)
    // RECORRER MAP (OK, FALTA MAP RECURSIVO)
    // HACER FIRMAS POLIMORFICAS
    // REVISAR 'FROM TEXT'
    public static String toText(Object object, String fieldSeparator, String valueSeparator, boolean calendarInMillis) {
        return toText(object, "\n", ":", calendarInMillis, 0, "  ");
    }

    @SuppressWarnings("unchecked")
    public static String toText(Object object, String fieldSeparator, String valueSeparator, boolean calendarInMillis, int level, String paddingSequence) {

        String padding = "";
        for (int i = 0; i < level; i++) {
            padding += paddingSequence;
        }

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(padding + "CLASS" + valueSeparator + object.getClass().getCanonicalName());
        Method[] objectMethods = object.getClass().getMethods();
        Object[] noArgs = new Object[0];
        int methodCount = objectMethods.length;
        for (int i = 0; i < methodCount; i++) {
            String methodName = objectMethods[i].getName();
            if (methodName.startsWith("get")) {
                String attributeName = methodName.substring(3).toUpperCase();
                if (attributeName.equals("CLASS")) {
                    continue;
                }
                try {
                    Object attribute = objectMethods[i].invoke(object, noArgs);
                    String attributeValue = "";

                    if (attribute instanceof Calendar) {
                        Calendar calendar = (Calendar) attribute;
                        if (calendarInMillis) {
                            attributeValue = "" + calendar.getTime().getTime();
                        } else {
                            attributeValue = calendar.getTime().toString();
                        }
                    } else if (attribute instanceof Enum) {
                        attributeValue = attribute.toString();
                    } else if (attribute instanceof List) {
                        attributeValue = "";
                        int elementCount = 0;
                        List elements = (List) attribute;
                        for (Object element : elements) {
                            attributeValue += fieldSeparator + padding + paddingSequence + "ELEMENT #" + (++elementCount) + fieldSeparator;
                            attributeValue += toText(element, fieldSeparator, valueSeparator, calendarInMillis, level + 2, paddingSequence);
                        }
                    } //						else if(attribute instanceof Map){
                    //							attributeValue = "";
                    //							Map elements = (Map) attribute;
                    //						    Iterator it = elements.entrySet().iterator();
                    //						    while (it.hasNext()) {
                    //						        Map.Entry pairs = (Map.Entry)it.next();
                    //								attributeValue += fieldSeparator + padding + paddingSequence + "ELEMENT '" + pairs.getKey() + "'" + fieldSeparator;
                    //								attributeValue += toText(pairs.getValue(), fieldSeparator, valueSeparator, calendarInMillis, level+2, paddingSequence);
                    //						    }
                    //						}
                    else {
                        if (attribute.getClass().getPackage().toString().contains("com.interax.telephony")) {
                            attributeValue = fieldSeparator;
                            attributeValue += toText(attribute, fieldSeparator, valueSeparator, calendarInMillis, level + 1, paddingSequence);
                        } else {
                            attributeValue = attribute.toString();
                        }
                    }
                    stringBuffer.append(fieldSeparator + padding + attributeName + valueSeparator + attributeValue);
                } catch (Exception e) {
                    stringBuffer.append(fieldSeparator + padding + attributeName + valueSeparator + "ERROR (" + e.getMessage() + ")");
                }

            }
        }
        return stringBuffer.toString();
    }

    @SuppressWarnings("unchecked")
    public static Object fromText(String text) {
        Hashtable<String, String> parsedData = parseText(text);
        try {
            Class clazz = Class.forName(parsedData.get("CLASS"));
            Object obj = clazz.newInstance();

            Method[] objectMethods = clazz.getMethods();
            int methodCount = objectMethods.length;
            for (int i = 0; i < methodCount; i++) {
                String methodName = objectMethods[i].getName();
                if (methodName.startsWith("set")) {
                    String attributeName = methodName.substring(3).toUpperCase();
                    String attributeValue = parsedData.get(attributeName);
                    try {
                        Class<?> parametersTypes[] = objectMethods[i].getParameterTypes();
                        String attributeType = parametersTypes[0].getName();
                        Object arg = null;

                        if (attributeType.equals("java.lang.String")) {
                            arg = attributeValue;
                        } else if (attributeType.equals("java.lang.Integer") || attributeType.equals("int")) {
                            arg = Integer.parseInt(attributeValue);
                        } else if (attributeType.equals("java.lang.Long") || attributeType.equals("long")) {
                            arg = Long.parseLong(attributeValue);
                        } else if (attributeType.equals("java.util.Calendar")) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTimeInMillis(Long.parseLong(attributeValue));
                            arg = calendar;

                        } else {
                            arg = null;
                        }

                        if (arg != null) {
                            Object args[] = new Object[1];
                            args[0] = arg;
                            objectMethods[i].invoke(obj, args);
                        }
                    } catch (Exception e) {
                        return null;
                    }
                }
            }

            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Hashtable<String, String> parseText(String text) {
        Hashtable<String, String> parsedText = new Hashtable<String, String>();
        String fields[] = text.split("\n");
        for (int i = 0; i < fields.length; i++) {
            String parsedField[] = fields[i].split(":");
            parsedText.put(parsedField[0], parsedField[1]);
        }
        return parsedText;
    }

    public static void main(String[] args) {
        System.out.println("converCreditCardNumber : " + converCreditCardNumber("4264289915888152"));
        //System.out.println("substringBetween " + substringBetween(source, "<countryid>", "</countryid>"));
        //System.out.println("getRamdomNumber(8) " +getRamdomNumber(0));
        //getRamdomLogin(6, 12899000L);
        //System.out.println(isNumeric("1000000"));
        //System.out.println(isNumeric("100.00"));
    }

    public static String getRamdomNumber(int digits) {
        //return a positive string-number of n digits
        if (digits <= 0) {
            throw new NumberFormatException("Digits cannot be zero or negative");
        }
        Random rand = new Random();
        String randomLong = String.valueOf(rand.nextLong());
        String randomString = randomLong.substring(1, digits + 1);
        return randomString;
    }

    public static String getRamdomLogin(int digits, Long id) {
        Random rand = new Random();
        String randomLong = String.valueOf(rand.nextLong());
        String randomString = randomLong.substring(1, digits + 1);
        int lenght = digits - id.toString().length();
        if (lenght <= 0) {
            throw new NumberFormatException("Digits cannot be smaller than id lenght");
        }
        String value = id.toString() + randomString.substring(0, lenght);
        return value;
    }

    public static String getCorrectAmount(String currencySymbol, float amount, int roundTo) {
        String format = "0.0";
        for (int i = 1; i < roundTo; i++) {
            format += "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(format);
        if (amount >= 0) {
            return decimalFormat.format(round(amount, roundTo)) +currencySymbol;
        } else {
            return decimalFormat.format(round(amount * -1, roundTo)) +"-" + currencySymbol;
        }
    }

    public static String getCorrectAmount(String currencySymbol, float amount, int roundTo, String format) {
        for (int i = 1; i < roundTo; i++) {
            format += "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(format);
        if (amount >= 0) {
            return decimalFormat.format(round(amount, roundTo)) +currencySymbol;
        } else {
            return decimalFormat.format(round(amount * -1, roundTo)) + "-" + currencySymbol ;
        }
    }

    public static float round(float d) {
        return round(d, 2);
    }

    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Double.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    public static boolean validateNumbers(String value) {

        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumeric(String value) {
        try {
            //Valida los enteros y los decimales
            Float.parseFloat(value);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static String substringBetween(String source, String beginValue, String endValue) {

        int init = source.indexOf(beginValue);
        if (init == -1) {
            return "error: beginValue not found.";
        }
        init += beginValue.length();
        int end = source.indexOf(endValue);
        if (end == -1) {
            return "error : endValue not found.";
        }
        end += endValue.length();
        String stringCut = source.substring(init, end);
        return stringCut;
    }

  
       public static byte[] converCreditCardNumber(String number) {
           //String encrytedNumber = "";
          byte[] creditCardNumber = null;
        try {
            if (number != null) {
                
                creditCardNumber = Encrypter.getInstance().encrypt(number.getBytes("UTF-8"));
                System.out.println(creditCardNumber);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
           return creditCardNumber;
    }
}
