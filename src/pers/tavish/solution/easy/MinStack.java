package pers.tavish.solution.easy;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

for more information: https://leetcode.com/problems/min-stack/description/
 */

import java.util.LinkedList;

public class MinStack {

    private LinkedList<Integer> stack;
    private Integer minElement;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        updateMin(x);
    }

    public void pop() {
        int x = stack.pop();
        updateMin(x);
    }

    private void updateMin(int x) {
        if (minElement == null || minElement > x) {
            minElement = x;
        } else {
            if (stack.isEmpty()) {
                minElement = null;
            } else {
                int t = Integer.MAX_VALUE;
                for (int i : stack) {
                    t = Math.min(t, i);
                }
                minElement = t;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minElement;
    }
}
