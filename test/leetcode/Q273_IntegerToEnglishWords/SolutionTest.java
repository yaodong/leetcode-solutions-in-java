package leetcode.Q273_IntegerToEnglishWords;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void toWords() {
        Solution solution = new Solution();

        assertEquals("One", solution.toWords(1));
        assertEquals("Zero", solution.toWords(0));

        assertEquals(
                "One Hundred Twenty Three",
                solution.toWords(123));

        assertEquals(
                "Twelve Thousand Three Hundred Forty Five",
                solution.toWords(12345));

        assertEquals(
                "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
                solution.toWords(1234567));

        assertEquals(
                "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One",
                solution.toWords(1234567891));
    }
}
