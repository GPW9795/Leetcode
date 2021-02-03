package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class _232_用栈实现队列_Y {
    class MyQueue {

        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            inStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            checkOutStack();
            return outStack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            checkOutStack();
            return outStack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void checkOutStack() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()){
                    outStack.push(inStack.pop());
                }
            }
        }
    }
}
