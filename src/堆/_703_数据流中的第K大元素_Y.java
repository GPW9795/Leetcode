package 堆;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 */
public class _703_数据流中的第K大元素_Y {
    private PriorityQueue<Integer> queue;
    private int limit;

    public _703_数据流中的第K大元素_Y(int k, int[] nums) {
        limit = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }

    }

    public int add(int val) {
        if (queue.size() < limit) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}
