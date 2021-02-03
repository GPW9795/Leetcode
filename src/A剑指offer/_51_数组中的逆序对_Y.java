package A剑指offer;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class _51_数组中的逆序对_Y {
    private int res = 0;
    private int[] tmp;

    public int[] reversePairs(int[] nums) {
        tmp = new int[nums.length];
        merge(nums, 0, nums.length - 1);
        return nums;
    }

    public void merge(int[] nums, int begin, int end) {
        if (begin >= end) return;
        int mid = (begin + end) >> 1;
        merge(nums, begin, mid);
        merge(nums, mid + 1, end);
        int l = begin, r = mid + 1;
        int index = begin;
        while (l <= mid && r <= end) {
            if (nums[l] <= nums[r]) {
                tmp[index++] = nums[l++];
            } else {
                res += mid - l + 1;
                tmp[index++] = nums[r++];
            }
        }
        while (l <= mid) {
            tmp[index++] = nums[l++];
        }
        while (r <= end) {
            tmp[index++] = nums[r++];
        }
        for (int i = begin; i <= end; i++) {
            nums[i] = tmp[i];
        }
    }
}
