package ro.mariantirlea.kata_roman_numerals;

import java.util.HashMap;
import java.util.Map;

public abstract class NumbersConverter {

    enum Symbol {

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
}
