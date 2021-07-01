package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 */
public class _155_最小栈_Y {
    /**
     * initialize your data structure here.
     */
    private final Stack<Integer> stack;
    private final Stack <Integer> minStack;

    public _155_最小栈_Y() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
