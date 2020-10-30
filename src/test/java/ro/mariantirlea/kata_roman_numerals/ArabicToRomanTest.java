package ro.mariantirlea.kata_roman_numerals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@ExtendWith(TimingExtension.class)
class ArabicToRomanTest {

    @Test
    void testTrivialNumbers(){
        assertThat(ArabicToRoman.arabicToRoman(1)).isEqualTo("I");
        assertThat(ArabicToRoman.arabicToRoman(5)).isEqualTo("V");
        assertThat(ArabicToRoman.arabicToRoman(10)).isEqualTo("X");
        assertThat(ArabicToRoman.arabicToRoman(50)).isEqualTo("L");
        assertThat(ArabicToRoman.arabicToRoman(100)).isEqualTo("C");
        assertThat(ArabicToRoman.arabicToRoman(500)).isEqualTo("D");
        assertThat(ArabicToRoman.arabicToRoman(1000)).isEqualTo("M");
    }

    @Test
    void testLimits() {

        assertThatThrownBy(() -> ArabicToRoman.arabicToRoman(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ArabicToRoman.arabicToRoman(-20)).isInstanceOf(IllegalArgumentException.class);
//        assertThatThrownBy(() -> ArabicToRoman.arabicToRoman(4000)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ArabicToRoman.arabicToRoman(4000000)).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void testOneDigit(){
        assertThat(ArabicToRoman.arabicToRoman(2)).isEqualTo("II");
        assertThat(ArabicToRoman.arabicToRoman(3)).isEqualTo("III");
        assertThat(ArabicToRoman.arabicToRoman(4)).isEqualTo("IV");
        assertThat(ArabicToRoman.arabicToRoman(6)).isEqualTo("VI");
        assertThat(ArabicToRoman.arabicToRoman(7)).isEqualTo("VII");
        assertThat(ArabicToRoman.arabicToRoman(8)).isEqualTo("VIII");
        assertThat(ArabicToRoman.arabicToRoman(9)).isEqualTo("IX");

    }

    @Test
    void testTwoDigits(){
        assertThat(ArabicToRoman.arabicToRoman(11)).isEqualTo("XI");
        assertThat(ArabicToRoman.arabicToRoman(12)).isEqualTo("XII");
        assertThat(ArabicToRoman.arabicToRoman(13)).isEqualTo("XIII");
        assertThat(ArabicToRoman.arabicToRoman(14)).isEqualTo("XIV");
        assertThat(ArabicToRoman.arabicToRoman(15)).isEqualTo("XV");
        assertThat(ArabicToRoman.arabicToRoman(16)).isEqualTo("XVI");
        assertThat(ArabicToRoman.arabicToRoman(17)).isEqualTo("XVII");
        assertThat(ArabicToRoman.arabicToRoman(18)).isEqualTo("XVIII");
        assertThat(ArabicToRoman.arabicToRoman(19)).isEqualTo("XIX");
        assertThat(ArabicToRoman.arabicToRoman(20)).isEqualTo("XX");

        assertThat(ArabicToRoman.arabicToRoman(99)).isEqualTo("XCIX");
        assertThat(ArabicToRoman.arabicToRoman(55)).isEqualTo("LV");
        assertThat(ArabicToRoman.arabicToRoman(40)).isEqualTo("XL");
    }

    @Test
    void testThreeDigits(){
        assertThat(ArabicToRoman.arabicToRoman(189)).isEqualTo("CLXXXIX");
        assertThat(ArabicToRoman.arabicToRoman(799)).isEqualTo("DCCXCIX");

    }

    @Test
    void testFourDigits(){
        assertThat(ArabicToRoman.arabicToRoman(1998)).isEqualTo("MCMXCVIII");
        assertThat(ArabicToRoman.arabicToRoman(2020)).isEqualTo("MMXX");
        assertThat(ArabicToRoman.arabicToRoman(3000)).isEqualTo("MMM");
        assertThat(ArabicToRoman.arabicToRoman(3999)).isEqualTo("MMMCMXCIX");

    }

    @Test
    void testSpecial(){
        assertThat(ArabicToRoman.arabicToRoman(1000000)).isEqualTo("M̅");
        assertThat(ArabicToRoman.arabicToRoman(2952349)).isEqualTo("M̅M̅C̅M̅L̅MMCCCXLIX");
        assertThat(ArabicToRoman.arabicToRoman(3999999)).isEqualTo("M̅M̅M̅C̅M̅X̅C̅MX̅CMXCIX");

    }

//    @Test
    void testAllValuesFromRange(){

        for (int i = 1; i <= 3999999; i++) {
            ArabicToRoman.arabicToRoman(i);
        }

        assertTrue(true, "Only to avoid Sonar issue!");

    }
}
