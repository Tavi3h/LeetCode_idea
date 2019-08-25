package pers.tavish.solution.medium;

/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

Example 1:

Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.

Note:

    - You must return the copy of the given head as a reference to the cloned list.

for more information: https://leetcode.com/problems/copy-list-with-random-pointer/description/
 */

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    private static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> hm = new HashMap<>();

        Node curNew = new Node();
        Node curOld = head;
        while (curOld != null) {
            hm.put(curOld, new Node(curOld.val, null, null));
            curNew.next = hm.get(curOld);
            curNew = curNew.next;
            curOld = curOld.next;
        }

        for (Node node : hm.keySet()) {
            hm.get(node).random = hm.get(node.random);
        }

        return hm.get(head);
    }
}
