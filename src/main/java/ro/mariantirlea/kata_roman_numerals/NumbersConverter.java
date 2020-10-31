package ro.mariantirlea.kata_roman_numerals;

import java.util.*;

public abstract class NumbersConverter {

    private static final LinkedList<String> symbols = new LinkedList<>(
            Arrays.asList("I", "V", "X", "L", "C", "D", "M", "V̅", "X̅", "L̅", "C̅", "D̅", "M̅"));

    protected static int getValueForSymbol(String symbol){
//        Arrays.asList("I", "V", "X", "L", "C", "D", "M", "V̅", "X̅", "L̅", "C̅", "D̅", "M̅"))
//                         1    5    10   50  100   500
//                         0    1    2    3    4     5
        int position = symbols.indexOf("X");

        int value = (int)Math.pow(10, (int)position / 2);

        if( position % 2 != 0){
            value *= 5;
        }

        return value;
    }

    protected static String getSymbolForValue(int value){
//        1 5 10 50 100 500 1000 5000
//        1 1 10 10 100 100 1000 1000
//        System.err.println(value);
        if(String.valueOf(value).startsWith("5")){
            return symbols.get((int)Math.log10((int)value / 5) * 2 + 1);
        }else{
//            System.err.println((int)Math.log10(value));
            return symbols.get((int)Math.log10(value) * 2);
        }

    }

    protected enum Symbol {

        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000),

        V̅(5000), //NOSONAR
        X̅(10000), //NOSONAR
        L̅(50000), //NOSONAR
        C̅(100000), //NOSONAR
        D̅(500000), //NOSONAR
        M̅(1000000); //NOSONAR

        private final int value;

        private static final Map<Integer, Symbol> lookup = new TreeMap<>();

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

        public static Optional<Symbol> getPrevious(Symbol current) {
            ArrayList<Symbol> values = (ArrayList)lookup.values();

            return Optional.ofNullable(values.get(values.indexOf(current) - 1));
        }
    }
}
