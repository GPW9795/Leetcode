package 数组或二分查找;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class _167_两数之和II_输入有序数组_Y {
    /**
     * 哈希表
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int num = target - numbers[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * 二分查找，首先固定一个数，然后在剩下的范围内做二分查找
     */
    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int num = target - numbers[i];
            int left = i + 1;
            int right = numbers.length;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (numbers[mid] == num) {
                    return new int[]{i + 1, mid + 1};
                }
                if (numbers[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 双指针，两边向中间靠近，每次计算两指针的和
     */
    public int[] twoSum2(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            }
            if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1, -1};
    }
}
