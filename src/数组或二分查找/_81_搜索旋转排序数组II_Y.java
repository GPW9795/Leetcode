package 数组或二分查找;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 */
public class _81_搜索旋转排序数组II_Y {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid]) {
                l++;
                continue;
            }
            if (nums[l] < nums[mid]) { // 前半部分有序
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else { // 后半部分有序
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
