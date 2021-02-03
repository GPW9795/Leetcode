package 数组或二分查找;

/**
 * https://leetcode-cn.com/problems/find-peak-element/
 */
public class _162_寻找峰值_Y {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    return 0;
                }
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) {
                    return nums.length - 1;
                }
            } else if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public int findPeakElement1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}
