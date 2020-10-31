package ro.mariantirlea.kata_roman_numerals;

public abstract class RomanToArabic extends NumbersConverter{

    private RomanToArabic(){
        throw new IllegalStateException();
    }

    public static int romanToArabic(String number){

        validate(number);

//                I(1),
//                V(5),
//                X(10),
//                L(50),
//                C(100),
//                D(500),
//                M(1000),

        int result = 0;
        for (int i = 0; i < number.length(); i++) {
//            System.err.println("Char: " + number.charAt(i));

            final char letter = number.charAt(i);

            if(String.valueOf(letter).equals("I")){
                result += 1;
            } else if(String.valueOf(letter).equals("V")){
                String xxx = Symbol.getPrevious(Symbol.valueOf("V")).get().name();
                System.err.println(xxx);
                if(i > 0 && String.valueOf(number.charAt(i - 1)).equals("I")){
                    result += (5 - 1 - 1);
                }else{
                    result += 5;
                }
            } else if(String.valueOf(letter).equals("X")){
                if(i > 0 && String.valueOf(number.charAt(i - 1)).equals("I")){
                    result += (10 - 1 - 1);
                }else{
                    result += 10;
                }
            }

        }

        return result;
    }

    private static void validate(String number) {

        //TODO validate all characters (allow only from enum Symbol)

        if(number.matches("I{4,}|X{4,}|C{4,}|M{4,}|D{2,}|L{2,}|V{2,}")){
            throw new IllegalArgumentException();
        }

    }
}
