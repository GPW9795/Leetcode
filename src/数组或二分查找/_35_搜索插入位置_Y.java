package 数组或二分查找;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class _35_搜索插入位置_Y {
    /**
     * 二分查找
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
