package pers.tavish.solution.medium;

/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

for more information: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 */

import pers.tavish.struct.TreeNode;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return root == null ? 0 : sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int i) {
        if (node == null) {
            return 0;
        }

        i = i * 10 + node.val;

        if (node.left == null && node.right == null) {
            return i;
        }

        return sumNumbers(node.left, i) + sumNumbers(node.right, i);
    }

}
