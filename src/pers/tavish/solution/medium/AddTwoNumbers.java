package pers.tavish.solution.medium;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

for more information: https://leetcode.com/problems/add-two-numbers/description/
 */

import org.junit.Test;
import pers.tavish.struct.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        } else {
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            int step = 0;
            while (l1 != null && l2 != null) {
                int val = l1.val + l2.val + step;
                step = 0;
                if (val >= 10) {
                    val -= 10;
                    step = 1;
                }
                curr.next = new ListNode(val);
                curr = curr.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            ListNode tmp = l1 == null ? l2 : l1;
            while (tmp != null) {
                int val = tmp.val + step;
                step = 0;
                if (val >= 10) {
                    val -= 10;
                    step = 1;
                }
                curr.next = new ListNode(val);
                curr = curr.next;
                tmp = tmp.next;
            }
            if (step == 1) {
                curr.next = new ListNode(step);
            }
            return dummy.next;
        }
    }

    @Test
    public void testCase() {
        ListNode l1 = ListNode.buildList(2, 4, 3);
        ListNode l2 = ListNode.buildList(5, 6, 4);
        System.out.println(addTwoNumbers(l1, l2));
    }

    /* 10ms
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        char[] result = convert(l1).add(convert(l2)).toString().toCharArray();

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        for (int i = result.length - 1; i >= 0; i--) {
            curr.next = new ListNode(result[i] - '0');
            curr = curr.next;
        }

        return dummyHead.next;
    }

    private BigInteger convert(ListNode listNode) {

        StringBuilder sb = new StringBuilder();

        while (true) {
            sb.append(listNode.val);
            if (listNode.next == null) {
                break;
            } else {
                listNode = listNode.next;
            }
        }

        return new BigInteger(sb.reverse().toString());
    }
     */
}
