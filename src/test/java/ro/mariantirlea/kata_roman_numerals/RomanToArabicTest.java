package ro.mariantirlea.kata_roman_numerals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RomanToArabicTest {

    @Test
    void testTrivialNumbers(){
        assertThat(RomanToArabic.romanToArabic("I")).isEqualTo(1);
        assertThat(RomanToArabic.romanToArabic("II")).isEqualTo(2);
        assertThat(RomanToArabic.romanToArabic("III")).isEqualTo(3);
        assertThat(RomanToArabic.romanToArabic("IV")).isEqualTo(4);
        assertThat(RomanToArabic.romanToArabic("V")).isEqualTo(5);
        assertThat(RomanToArabic.romanToArabic("VI")).isEqualTo(6);
        assertThat(RomanToArabic.romanToArabic("VII")).isEqualTo(7);
        assertThat(RomanToArabic.romanToArabic("VIII")).isEqualTo(8);
        assertThat(RomanToArabic.romanToArabic("IX")).isEqualTo(9);
        assertThat(RomanToArabic.romanToArabic("X")).isEqualTo(10);
    }

    @Test
    void testInvalidNumbers(){
        assertThatThrownBy(() -> RomanToArabic.romanToArabic("IIII")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> RomanToArabic.romanToArabic("XXXX")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> RomanToArabic.romanToArabic("CCCC")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> RomanToArabic.romanToArabic("MMMM")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> RomanToArabic.romanToArabic("DD")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> RomanToArabic.romanToArabic("LL")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> RomanToArabic.romanToArabic("VV")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testTwoDigits(){
        assertThat(RomanToArabic.romanToArabic("XI")).isEqualTo(11);
        assertThat(RomanToArabic.romanToArabic("XII")).isEqualTo(12);
        assertThat(RomanToArabic.romanToArabic("XIII")).isEqualTo(13);
        assertThat(RomanToArabic.romanToArabic("XIV")).isEqualTo(14);
        assertThat(RomanToArabic.romanToArabic("XV")).isEqualTo(15);
        assertThat(RomanToArabic.romanToArabic("XVI")).isEqualTo(16);
        assertThat(RomanToArabic.romanToArabic("XVII")).isEqualTo(17);
        assertThat(RomanToArabic.romanToArabic("XVIII")).isEqualTo(18);
        assertThat(RomanToArabic.romanToArabic("XIX")).isEqualTo(19);
        assertThat(RomanToArabic.romanToArabic("XX")).isEqualTo(20);
    }

    @Test
    void testAllSymbols(){
        assertThat(RomanToArabic.romanToArabic("XXXVIII")).isEqualTo(38);
        assertThat(RomanToArabic.romanToArabic("MCMLXXXVI")).isEqualTo(1986);
    }
}