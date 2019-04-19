package leetcode.Q125_ValidPalindrome;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void isPalindrome() {
        Solution solution = new Solution();

        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(solution.isPalindrome(""));
        assertTrue(solution.isPalindrome("a"));
        assertFalse(solution.isPalindrome("A man, a plan"));

    }

}
