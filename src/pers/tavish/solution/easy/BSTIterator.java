package pers.tavish.solution.easy;

/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Example:

BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false

Note:

    - next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
    - You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.

for more information: https://leetcode.com/problems/binary-search-tree-iterator/description/
 */

import pers.tavish.struct.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BSTIterator {

    private Iterator<Integer> iter;

    public BSTIterator(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        iter = list.iterator();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return iter.next();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return iter.hasNext();
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}
