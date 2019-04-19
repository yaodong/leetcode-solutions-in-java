package leetcode.Q3_LongestSubstringNoRepeat;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private Solution longestSubstring;

    @Before
    public void setSolution() {
        this.longestSubstring = new Solution();
    }

    @Test
    public void testSolution() {
        assertEquals(3, longestSubstring.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, longestSubstring.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, longestSubstring.lengthOfLongestSubstring("pwwkew"));
    }

}