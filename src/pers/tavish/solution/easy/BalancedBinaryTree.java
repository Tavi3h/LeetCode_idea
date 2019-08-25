package pers.tavish.solution.easy;

/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.

for more information: https://leetcode.com/problems/balanced-binary-tree/description/
 */

import pers.tavish.struct.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return root == null || (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode node) {
        return node == null ? 0 : 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}
