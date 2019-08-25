package pers.tavish.solution.medium;

/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

for more information: https://leetcode.com/problems/reorder-list/description/
 */

import pers.tavish.struct.ListNode;

import java.util.HashMap;
import java.util.Map;

public class ReorderList {
    public void reorderList(ListNode head) {
        Map<ListNode, ListNode> hm = new HashMap<>();
        ListNode curr = head, tail = null;
        while (curr != null) {
            if (curr.next == null) {
                tail = curr;
                break;
            }
            hm.put(curr.next, curr);
            curr = curr.next;
        }

        while (head != tail && head.next != tail) {
            tail.next = head.next;
            head.next = tail;
            head = tail.next;
            tail = hm.get(tail);
            tail.next = null;
        }
    }
}
