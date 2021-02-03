package 队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class _225_用队列实现栈_Y {
    private Deque<Integer> stack;
    /** Initialize your data structure here. */
    public _225_用队列实现栈_Y() {
        stack = new ArrayDeque<>();
    }

    // 只在队列尾部入队和出队
    /** Push element x onto stack. */
    public void push(int x) {
        stack.offerLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return stack.pollLast();
    }

    /** Get the top element. */
    public int top() {
        return stack.peekLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
