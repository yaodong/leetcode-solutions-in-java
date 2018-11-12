package q001;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setSolution() {
        this.solution = new Solution();
    }

    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[]{1, 3}, solution.twoSum(new int[]{13, 7, 11, 2}, 9));
    }

}