package q125;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidPalindromeTest {

    @Test
    public void isPalindrome() {
        ValidPalindrome solution = new ValidPalindrome();

        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(solution.isPalindrome(""));
        assertTrue(solution.isPalindrome("a"));
        assertFalse(solution.isPalindrome("A man, a plan"));

    }

}
