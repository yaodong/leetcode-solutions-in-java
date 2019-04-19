package leetcode.Q45_JumpGame2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void jump() {
        Solution solution = new Solution();

        assertEquals(2, solution.jump(new int[]{2, 3, 1, 1, 4}));
    }
}
