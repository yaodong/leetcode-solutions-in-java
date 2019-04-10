package leetcode.q005;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setSolution() {
        this.solution = new Solution();
    }

    @Test
    public void testSolution() {
        assertEquals("abba", solution.longestPalindrome("cbbdeabbaa"));
    }
}