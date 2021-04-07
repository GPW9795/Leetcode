package A剑指offer;

/**
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class _53_I_在排序数组中查找数字I_Y {
    /**
     * 二分查找
     */
    public static int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int left = 0, right = 1;
        while (i <= j) {
            int m = (i + j) >> 1;
            if (nums[m] < target) {
                i = m + 1;
            } else if (nums[m] > target) {
                j = m - 1;
            } else {
                left = right = m;
                while (left >= 0 && nums[left] == target) {
                    left--;
                }
                while (right < nums.length && nums[right] == target) {
                    right++;
                }
                break;
            }
        }
        return right - left - 1;
    }

    /**
     * 二分查找优化
     */
    public int search1(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    public int helper(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        int target = 2;
        System.out.println(search(nums, target));
    }
}
