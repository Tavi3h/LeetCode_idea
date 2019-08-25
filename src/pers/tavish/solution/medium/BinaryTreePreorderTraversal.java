package pers.tavish.solution.medium;

/*
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?

for more information: https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 */

import pers.tavish.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    // Recursive
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        preorderTraversal(root, res);
//        return res;
//    }
//
//    private void preorderTraversal(TreeNode node, List<Integer> res) {
//        if (node == null) {
//            return;
//        }
//        res.add(node.val);
//        preorderTraversal(node.left);
//        preorderTraversal(node.right);
//    }

    // iteratively
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode top = stack.pop();
                res.add(top.val);
                if (top.right != null) {
                    stack.push(top.right);
                }
                if (top.left != null) {
                    stack.push(top.left);
                }
            }
        }
        return res;
    }
}
