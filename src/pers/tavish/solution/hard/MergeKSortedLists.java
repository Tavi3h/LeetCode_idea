package pers.tavish.solution.hard;

/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

for more information: https://leetcode.com/problems/merge-k-sorted-lists/description/
 */

import org.junit.Test;
import pers.tavish.struct.ListNode;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return lists == null || lists.length == 0 ? null : mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int lo, int hi) {

        if (lo == hi) {
            return lists[lo];
        }

        int mid = lo + (hi - lo >>> 1);

        ListNode l1 = mergeKLists(lists, lo, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, hi);

        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        ListNode l1 = ListNode.buildList(1, 4, 5);
        ListNode l2 = ListNode.buildList(1, 3, 4);
        ListNode l3 = ListNode.buildList(2, 6);
        ListNode[] lists = {l1, l2, l3};
        System.out.println(mergeKLists(lists));
    }
}
