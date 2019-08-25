package pers.tavish.solution.hard;

/*
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?

for more information: https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 */

import pers.tavish.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    // Recursive
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        postorderTraversal(root, res);
//        return res;
//    }
//
//    private void postorderTraversal(TreeNode node, List<Integer> res) {
//        if (node == null) {
//            return;
//        }
//        postorderTraversal(node.left, res);
//        postorderTraversal(node.right, res);
//        res.add(node.val);
//    }

    // iteratively
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode top = stack.pop();
                res.add(0, top.val);
                if (top.left != null) {
                    stack.push(top.left);
                }
                if (top.right != null) {
                    stack.push(top.right);
                }
            }
        }
        return res;
    }
}
