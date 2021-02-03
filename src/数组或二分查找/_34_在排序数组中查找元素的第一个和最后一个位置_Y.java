package 数组或二分查找;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置_Y {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                int start = mid, end = mid;
                while (start > 0 && nums[start - 1] == target) {
                    start--;
                }
                while (end < nums.length - 1 && nums[end + 1] == target) {
                    end++;
                }
                return new int[]{start, end};
            }
        }
        return new int[]{-1, -1};
    }
}
