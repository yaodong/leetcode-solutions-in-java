package leetcode.q009;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeNumberTest {

    @Test
    public void testSolution() {
        assertTrue(PalindromeNumber.isPalindrome(0));
        assertTrue(PalindromeNumber.isPalindrome(1));
        assertTrue(PalindromeNumber.isPalindrome(1234321));

        assertFalse(PalindromeNumber.isPalindrome(100));
    }

}
