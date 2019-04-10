package leetcode.q002;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setSolution() {
        this.solution = new Solution();
    }

    @Test
    public void testSolution() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode actual = solution.addTwoNumbers(l1, l2);
        assertEquals(7, actual.val);
        assertEquals(0, actual.next.val);
        assertEquals(8, actual.next.next.val);
        assertNull(actual.next.next.next);

    }

}