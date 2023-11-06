import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringProblemsTest {
    StringProblems stringProblems = new StringProblems();

    @Test
    void findNeedleInHaystackNotFound() {
        assertEquals(-1, stringProblems.findNeedleInHaystack("test11234", "6"));
    }

    @Test
    void findNeedleInHaystackFoundAtStart() {
        assertEquals(0, stringProblems.findNeedleInHaystack("test11234", "test"));
    }

    @Test
    void findNeedleInHaystackFoundInBetween() {
        assertEquals(4, stringProblems.findNeedleInHaystack("test11234", "112"));
    }

    @Test
    void findNeedleInHaystackPartialFound() {
        assertEquals(-1, stringProblems.findNeedleInHaystack("test11234", "1125"));
    }

    @Test
    void findNeedleInHaystackNeedleStackLengthIsGreater() {
        assertEquals(-1, stringProblems.findNeedleInHaystack("test11234", "1125rtyuiui"));
    }


    @Test
    void findNeedleInHaystackFoundInBetween2() {
        assertEquals(-1, stringProblems.findNeedleInHaystack("test11234", "2345"));
    }
    @Test
    void findNeedleInHaystackFoundInBetween3() {
        assertEquals(4, stringProblems.findNeedleInHaystack("mississippi", "issip"));
    }

    @Test
    void findNeedleInHaystackFoundInBetween4() {
        assertEquals(9, stringProblems.findNeedleInHaystack("mississippi", "pi"));
    }

    @Test
    void romanToIntFor10() {
        assertEquals(10, stringProblems.romanToInt2("X"));
    }

    @Test
    void romanToIntFor20() {
        assertEquals(20, stringProblems.romanToInt2("XX"));
        assertEquals(500, stringProblems.romanToInt2("D"));
    }

    @Test
    void romanToIntFor27() {
        assertEquals(27, stringProblems.romanToInt2("XXVII"));
        assertEquals(58, stringProblems.romanToInt2("LVIII"));
    }

    @Test
    void romanToIntFor9() {
        assertEquals(9, stringProblems.romanToInt2("IX"));
        assertEquals(1994, stringProblems.romanToInt2("MCMXCIV"));
    }

    @Test
    void lengthOfLastWord() {
        assertEquals(0, stringProblems.lengthOfLastWord(""));
        assertEquals(4, stringProblems.lengthOfLastWord("test"));
        assertEquals(4, stringProblems.lengthOfLastWord("   fly me   to   the moon  "));
        assertEquals(6, stringProblems.lengthOfLastWord("luffy is still joyboy"));
    }
}