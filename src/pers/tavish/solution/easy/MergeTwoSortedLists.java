package pers.tavish.solution.easy;

/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

for more information: https://leetcode.com/problems/merge-two-sorted-lists/description/
 */

import org.junit.Test;
import pers.tavish.struct.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    @Test
    public void testCase() {
        ListNode l1 = ListNode.buildList(1, 2, 4);
        ListNode l2 = ListNode.buildList(1, 3, 4);
        System.out.println(mergeTwoLists(l1, l2));
    }
}
