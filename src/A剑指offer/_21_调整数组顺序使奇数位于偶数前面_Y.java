package A剑指offer;

public class _21_调整数组顺序使奇数位于偶数前面_Y {
    /**
     * 首尾双指针
     */
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if ((nums[l] & 1) == 1) {
                l++;
            } else {
                if ((nums[r] & 1) == 0) {
                    r--;
                } else {
                    int tmp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = tmp;
                }
            }
        }
        return nums;
    }

    /**
     * 快慢指针
     */
    public int[] exchange1(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if ((nums[fast] & 1) == 1) {
                int tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tmp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
}
