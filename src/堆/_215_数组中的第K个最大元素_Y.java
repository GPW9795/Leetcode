package 堆;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class _215_数组中的第K个最大元素_Y {
    /**
     * 使用内置工具类排序数组后输出
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 使用堆解决，找到第K的元素，使用堆解决（优先级队列）
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.offer(nums[i]);
            } else if (queue.peek() < nums[i]) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }

    public static int findKthLargest2(int[] nums, int k) {
        //原地建堆
        int size = nums.length;
        int heapSize = size;
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            siftDown(nums, i, heapSize);
        }
        // 堆顶出队
        for (int i = size - 1; i >= size - k + 1; i--) {
            swap(nums, 0, i);
            heapSize--;
            siftDown(nums, 0, heapSize);
        }
        return nums[0];
    }

    private static void siftDown(int[] nums, int index, int size) {
        int half = size >> 1;
        int value = nums[index];
        while (index < half) {
            int childIndex = (index << 1) + 1;
            int child = nums[childIndex];

            int rightIndex = childIndex + 1;
            if (rightIndex < size && nums[rightIndex] > child) {
                child = nums[childIndex = rightIndex];
            }

            if (value > child) break;

            nums[index] = child;
            index = childIndex;
        }
        nums[index] = value;
    }

    private static void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k =2;
        System.out.println(findKthLargest2(nums,k));
    }

}
