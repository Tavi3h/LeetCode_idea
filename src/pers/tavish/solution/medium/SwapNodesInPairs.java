package pers.tavish.solution.medium;

/*
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.

for more information: https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */

import pers.tavish.struct.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = first.next;
            first.next = second.next;
            curr.next = second;
            curr.next.next = first;
            curr = first;
        }
        return dummy.next;
    }
}
