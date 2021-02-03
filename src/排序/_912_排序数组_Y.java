package 排序;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-an-array/
 */
public class _912_排序数组_Y {
    /**
     * 内置
     */
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 排序.冒泡排序
     */
    public int[] sortArray1(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            int lastIndex = 0;
            for (int j = 1; j <= i; j++) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                    lastIndex = j;
                }
            }
            i = lastIndex;
        }
        return nums;
    }

    /**
     * 选择排序
     */
    public int[] sortArray2(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            int index = 0;
            for (int j = 1; j <= i; j++) {
                if (nums[index] <= nums[j]) {
                    index = j;
                }
            }
            swap(nums, index, i);
        }
        return nums;
    }

    /**
     * 插入排序
     */
    public int[] sortArray3(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int cur = i;
            int value = nums[i];
            while (nums[cur] < nums[cur - 1]){
                nums[cur] = nums[cur-1];
            }
            nums[cur] = value;
        }
        return nums;
    }

    /**
     * 堆排序
     */
    public int[] sortArray4(int[] nums) {
        //原地建堆
        int heapSize = nums.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(nums, i, heapSize);
        }
        while(heapSize > 1){
            swap(nums, 0, --heapSize);
            siftDown(nums, 0, heapSize);
        }
        return nums;
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

    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
