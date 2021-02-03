package 双指针;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 */
public class _16_最接近的三数之和_Y {
    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int key = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int L = i + 1;
            int R = len - 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                int result = sum - target;
                if (Math.abs(result) < key) {
                    ans = sum;
                    key = Math.abs(result);
                }
                if (result == 0) return ans;
                if (result > 0) {
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    R--;
                } else {
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    L++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1};
        int target = 3;
        System.out.println(threeSumClosest(nums, target));
    }
}
