package pers.tavish.solution.medium;

/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?

for more information: https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 */

import pers.tavish.struct.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    // Recursive
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        inorderTraversal(res, root);
//        return res;
//    }
//
//    private void inorderTraversal(List<Integer> res, TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        inorderTraversal(res, root.left);
//        res.add(root.val);
//        inorderTraversal(res, root.right);
//    }

    // iteratively
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
