package pers.tavish.solution.medium;

/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

 for more information: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 */

import pers.tavish.struct.ListNode;
import pers.tavish.struct.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head, slow);
        root.right = sortedListToBST(slow.next, tail);
        return root;
    }
}
