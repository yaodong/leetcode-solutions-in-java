package leetcode.Q146_LRUCache;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void test() {
        Solution cache = new Solution(2);
        cache.put(1, 1);
        cache.put(2, 2);

        assertEquals(1, cache.get(1));

        cache.put(3, 3);
        assertEquals(-1, cache.get(2));

        cache.put(4, 4);
        assertEquals(-1, cache.get(1));

        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }
}
