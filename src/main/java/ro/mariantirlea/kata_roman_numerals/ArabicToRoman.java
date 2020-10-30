package ro.mariantirlea.kata_roman_numerals;

public abstract class ArabicToRoman {

    private ArabicToRoman(){
        throw new IllegalStateException();
    }

    public static String arabicToRoman(int number){
        switch (number){
            case 1:
                return "I";
            case 5:
                return "V";
            case 10:
                return "X";
            case 50:
                return "L";
            case 100:
                return "C";
            case 500:
                return "D";
            case 1000:
                return "M";
            default:
                throw new IllegalArgumentException();
        }

    }

}
