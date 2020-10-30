package ro.mariantirlea.kata_roman_numerals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RomanToArabicTest {

    @Test
    void testTrivialNumbers(){
        assertThat(RomanToArabic.romanToArabic("I")).isEqualTo(1);
    }

}