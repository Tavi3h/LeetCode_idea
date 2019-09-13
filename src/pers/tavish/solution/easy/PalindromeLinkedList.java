package pers.tavish.solution.easy;

/*

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false

Example 2:

Input: 1->2->2->1
Output: true

Follow up:

Could you do it in O(n) time and O(1) space?

for more information: https://leetcode.com/problems/palindrome-linked-list/description/
 */

import pers.tavish.struct.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode revHead = fast == null ? reverseList(slow) : reverseList(slow.next);

        while (revHead != null) {
            if (revHead.val != head.val) {
                return false;
            }
            revHead = revHead.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
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
