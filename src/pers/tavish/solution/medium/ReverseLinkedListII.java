package pers.tavish.solution.medium;

/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

for more information: https://leetcode.com/problems/reverse-linked-list-ii/description/
 */

import pers.tavish.struct.ListNode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == n) {
            return head;
        }

        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;

        ListNode curr = dummy;
        for (int i = 0; i < m - 1; i++) {
            curr = curr.next;
        }

        ListNode start = curr.next;
        curr.next = null;
        ListNode p = start, q = null;
        for (int i = 0; i <= n - m; i++) {
            ListNode pr = p.next;
            p.next = q;
            if (i == n - m) {
                curr.next = p;
                start.next = pr;
            } else {
                q = p;
                p = pr;
            }
        }
        return dummy.next;
    }
}
