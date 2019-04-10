package leetcode.q045;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JumpGame2Test {

    @Test
    public void jump() {
        JumpGame2 solution = new JumpGame2();

        assertEquals(2, solution.jump(new int[]{2, 3, 1, 1, 4}));
    }
}
