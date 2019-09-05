package pers.tavish.solution.easy;

/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

for more informaiton: https://leetcode.com/problems/reverse-linked-list/description/
 */

import pers.tavish.struct.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head.next;
        head.next = null;
        ListNode q = reverseList(p);
        p.next = head;
        return q;
    }
}
