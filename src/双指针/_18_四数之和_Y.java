package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/4sum/
 */
public class _18_四数之和_Y {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (nums == null || len < 4) return list;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 最小的四个数都大于target 直接退出
            if ((nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3]) > target) break;
            // 最大的四个数都小于target 跳过这层循环
            if ((nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3]) < target) continue;
            // 转为三数之和
            int threeSum = target - nums[i];
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // 最小的三个数都大于threeSum 直接退出
                if ((nums[j] + nums[j + 1] + nums[j + 2]) > threeSum) break;
                // 最大的三个数都小于threeSum 跳过这层循环
                if ((nums[j] + nums[len - 1] + nums[len - 2]) < threeSum) continue;
                int L = j + 1;
                int R = len - 1;
                while (L < R) {
                    int sum = nums[j] + nums[L] + nums[R];
                    if (sum == threeSum) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        while (L < R && nums[L] == nums[L + 1]) L++;
                        while (L < R && nums[R] == nums[R - 1]) R--;
                        L++;
                        R--;
                    } else if (sum < threeSum) {
                        L++;
                    } else {
                        R--;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }


}
