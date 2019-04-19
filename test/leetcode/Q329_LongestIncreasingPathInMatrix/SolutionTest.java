package leetcode.Q329_LongestIncreasingPathInMatrix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setSolution() {
        this.solution = new Solution();
    }

    @Test
    public void testSolution() {
        int[][] data = new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        assertEquals(4, solution.longestIncreasingPath(data));
    }

}