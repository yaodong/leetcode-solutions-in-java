package leetcode.q002;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode curr = head;
        int carry = 0;

        while (p1 != null || p2 != null) {
            int v1 = (p1 != null) ? p1.val : 0;
            int v2 = (p2 != null) ? p2.val : 0;

            int sum = v1 + v2 + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            p1 = (p1 == null) ? null : p1.next;
            p2 = (p2 == null) ? null : p2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(1);
        }

        return head.next;
    }
}
