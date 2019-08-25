package pers.tavish.solution.medium;

/*
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

    - You may only use constant extra space.
    - Recursive approach is fine, implicit stack space does not count as extra space for this problem.

for more information: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 */




public class PopulatingNextRightPointersInEachNodeII {


    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node node = root.next;
        while (node != null) {
            if (node.left != null) {
                node = node.left;
                break;
            }
            if (node.right != null) {
                node = node.right;
                break;
            }
            node = node.next;
        }

        if (root.right != null) {
            root.right.next = node;
        }
        if (root.left != null) {
            root.left.next = root.right == null ? node : root.right;
        }

        connect(root.right);
        connect(root.left);
        return root;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
