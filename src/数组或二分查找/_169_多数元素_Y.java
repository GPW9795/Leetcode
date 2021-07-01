package 数组或二分查找;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/majority-element/
 */
public class _169_多数元素_Y {
    /**
     * 直接排列时间复杂度O(nlogn),空间复杂度O(1)
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Arrays.sort(nums);
        int n = nums.length / 2;
        return nums[n];
    }

    /**
     * 哈希时间复杂度O(n),空间复杂度O(n)
     *
     */
    public int majorityElement1(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length / 2;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int count = map.get(num) + 1;
                if (count > n) {
                    return num;
                } else {
                    map.put(num, count);
                }
            } else {
                map.put(num, 1);
            }
        }
        return nums[0];
    }

    /**
     * 摩尔算法
     */
    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (res == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = nums[i];
                count++;
            }
        }
        return res;
    }

    /**
     * 简单摩尔算法
     */
    public int majorityElement3(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Integer res = null;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            count += (num == res) ? 1 : -1;
        }
        return res;
    }
}
