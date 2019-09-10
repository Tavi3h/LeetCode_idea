package pers.tavish.solution.easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.poll());
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.poll());
        }
        int x = queue.peek();
        queue.add(queue.poll());
        return x;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
