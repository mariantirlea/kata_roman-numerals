package ro.mariantirlea.kata_roman_numerals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArabicToRomanTest {

    @Test
    public void testTrivialNumbers(){
        assertThat(ArabicToRoman.arabicToRoman(1)).isEqualTo("I");
        assertThat(ArabicToRoman.arabicToRoman(5)).isEqualTo("V");
        assertThat(ArabicToRoman.arabicToRoman(10)).isEqualTo("X");
        assertThat(ArabicToRoman.arabicToRoman(50)).isEqualTo("L");
        assertThat(ArabicToRoman.arabicToRoman(100)).isEqualTo("C");
        assertThat(ArabicToRoman.arabicToRoman(500)).isEqualTo("D");
        assertThat(ArabicToRoman.arabicToRoman(1000)).isEqualTo("M");
    }

}
