package pers.tavish.solution.medium;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

for more information: https://leetcode.com/problems/path-sum-ii/description/
 */

import pers.tavish.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            pathSum(res, new ArrayList<>(), root, sum);
        }
        return res;
    }

    private void pathSum(List<List<Integer>> res, ArrayList<Integer> list, TreeNode node, int sum) {
        if (node == null) {
            return;
        }

        list.add(node.val);

        if (sum == node.val && node.left == null && node.right == null) {
            res.add(new ArrayList<>(list));
        }

        pathSum(res, list, node.left, sum - node.val);
        pathSum(res, list, node.right, sum - node.val);
        list.remove(list.size() - 1);

    }
}
