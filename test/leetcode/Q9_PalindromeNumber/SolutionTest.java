package leetcode.Q9_PalindromeNumber;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void testSolution() {
        assertTrue(Solution.isPalindrome(0));
        assertTrue(Solution.isPalindrome(1));
        assertTrue(Solution.isPalindrome(1234321));

        assertFalse(Solution.isPalindrome(100));
    }

}
