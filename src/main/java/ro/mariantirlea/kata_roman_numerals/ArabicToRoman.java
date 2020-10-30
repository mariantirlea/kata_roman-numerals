package ro.mariantirlea.kata_roman_numerals;

import java.util.HashMap;
import java.util.Map;

public abstract class ArabicToRoman {

    public static final int LIMIT_ARABIC_LOW = 1;
    public static final int LIMIT_ARABIC_HIGH = 3999999;

    private enum Symbol {

        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000),

        @SuppressWarnings("java:S115")
        V̅(5000),
        @SuppressWarnings("java:S115")
        X̅(10000),
        @SuppressWarnings("java:S115")
        L̅(50000),
        @SuppressWarnings("java:S115")
        C̅(100000),
        @SuppressWarnings("java:S115")
        D̅(500000),
        @SuppressWarnings("java:S115")
        M̅(1000000);

        private final int value;

        private static final Map<Integer, Symbol> lookup = new HashMap<>();

        static {
            for (Symbol symbol : Symbol.values()) {
                lookup.put(symbol.getValue(), symbol);
            }
        }

        Symbol(final int value) {
            this.value = value;
        }

        public int getValue() { return value; }

        public static Symbol get(int value) {
            return lookup.get(Integer.valueOf(value));
        }
    }

    private ArabicToRoman(){
        throw new IllegalStateException();
    }

    public static String arabicToRoman(int number){

        validate(number);

        return extractRomanFromArabic(number);
    }

    private static String extractRomanFromArabic(int number) {
        StringBuilder sb = new StringBuilder();

        int length = getNumberOfDigits(number);

        int numberTemp = number;
        for (int i = 0; i < length; i++) {
            double temp = Math.pow(10, (double)length - i - 1);

            sb.append(getRomanSymbols((int) (numberTemp / temp), length - i));
            numberTemp = (int) (numberTemp % temp);
        }

        return sb.toString();
    }

    private static String getRomanSymbols(int number, int length) {

        if(number == 0){
            return "";
        }

        if(number <= 3){

            return repeat(symbolForNumberAndLength(1, length - 1), number);
        } else if (number == 4){

            return symbolForNumberAndLength(1, length - 1) +
                    symbolForNumberAndLength(5, length - 1);

        } else if(number <= 8){

            return symbolForNumberAndLength(5, length - 1) +
                    repeat(symbolForNumberAndLength(1, length - 1), number - 5);

        } else {

            return symbolForNumberAndLength(1, length - 1) +
                    symbolForNumberAndLength(1, length);
        }

    }

    private static String symbolForNumberAndLength(int number, int length) {
        return Symbol.get((int) (number * Math.pow(10, length))).name();
    }

    private static String repeat(String symbol, int number) {
        return new String(new char[number]).replace("\0", symbol);
    }

    private static int getNumberOfDigits(int number) {
        return (int) (Math.log10(number) + 1);
    }

    private static void validate(int number) {
        if(number < LIMIT_ARABIC_LOW || number > LIMIT_ARABIC_HIGH){
            throw new IllegalArgumentException();
        }
    }

}
