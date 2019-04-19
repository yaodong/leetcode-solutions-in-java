package leetcode.Q174_DungeonGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void calculateMinimumHP() {

        Solution solution = new Solution();

        assertEquals(7, solution.calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        }));
    }
}
