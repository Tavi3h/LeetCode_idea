package pers.tavish.solution.medium;

/*

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:

You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

for more information: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */

import pers.tavish.struct.TreeNode;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        int nodeCount = count(root.left);
        return k <= nodeCount ? kthSmallest(root.left, k)
                : (k == nodeCount + 1 ? root.val : kthSmallest(root.right, k - nodeCount - 1));
    }

    private int count(TreeNode node) {
        return node == null ? 0 : count(node.left) + count(node.right) + 1;
    }
}
