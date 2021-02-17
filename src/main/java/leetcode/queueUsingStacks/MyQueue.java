package leetcode.queueUsingStacks;

import java.util.Stack;

class MyQueue {

public  Stack<Integer> queue;
public  Stack<Integer> revertQueue;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.queue = new Stack<>();
        this.revertQueue = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!queue.empty()) {
            revertQueue.push(queue.pop());
        }
        revertQueue.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!revertQueue.empty()) {
            queue.push(revertQueue.pop());
        }
        return queue.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!revertQueue.empty()) {
            queue.push(revertQueue.pop());
        }
        return queue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.empty() && revertQueue.empty();

    }
}

