package 双指针;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class _283_移动零_Y {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    /**
     * 优化
     */
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
