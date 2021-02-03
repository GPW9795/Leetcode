package A剑指offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 */
public class _59_II队列的最大值_Y {
    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public _59_II队列的最大值_Y() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        queue.offer(value);
        deque.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int num = queue.poll();
        if (num == deque.peekFirst()) {
            deque.pollFirst();
        }
        return num;
    }
}
