package pers.tavish.solution.medium;

/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2

Example 2:

Input: 1->1->2->3->3
Output: 1->2->3

for more information: https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */

import pers.tavish.struct.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            if (curr == null || curr.val != head.val) {
                head.next = curr;
                head = head.next;
            }
        }
        return dummy.next;
    }
}
