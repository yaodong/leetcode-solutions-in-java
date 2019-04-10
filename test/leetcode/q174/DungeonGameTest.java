package leetcode.q174;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DungeonGameTest {

    @Test
    public void calculateMinimumHP() {

        DungeonGame solution = new DungeonGame();

        assertEquals(7, solution.calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        }));
    }
}
