package ro.mariantirlea.kata_roman_numerals;

public abstract class ArabicToRoman extends NumbersConverter{

    public static final int LIMIT_ARABIC_LOW = 1;
    public static final int LIMIT_ARABIC_HIGH = 3999999;

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

//            getSymbolForValue(number * (int)Math.pow(10, length - 1));

            return repeat(getSymbolForValue(1 * (int)Math.pow(10, length - 1)), number);
        } else if (number == 4){

            return getSymbolForValue(1 * (int)Math.pow(10, length - 1)) +
                    getSymbolForValue(5 * (int)Math.pow(10, length - 1));

        } else if(number <= 8){

            return getSymbolForValue(5 * (int)Math.pow(10, length - 1)) +
                    repeat(getSymbolForValue(1 * (int)Math.pow(10, length - 1)), number - 5);

        } else {

            return getSymbolForValue(1 * (int)Math.pow(10, length - 1)) +
                    getSymbolForValue(1 * (int)Math.pow(10, length));
        }

    }

    private static String symbolForNumberAndLength(int number, int length) {
        System.err.println(number+ "   "+ getSymbolForValue(number));
        return getSymbolForValue(number);
//        return Symbol.get((int) (number * Math.pow(10, length))).name();
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
