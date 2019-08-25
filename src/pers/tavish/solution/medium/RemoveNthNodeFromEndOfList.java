package pers.tavish.solution.medium;

/*

Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?

for more information: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */

import org.junit.Test;
import pers.tavish.struct.ListNode;

public class RemoveNthNodeFromEndOfList {

    // one-pass
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode fast = dummy, slow = dummy;
        dummy.next = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    @Test
    public void testCase() {
        ListNode head = ListNode.buildList(1, 2, 3, 4, 5, 6);
        System.out.println(removeNthFromEnd(head, 2));
    }
}
