package 动态规划;

/**
 * https://leetcode-cn.com/problems/jump-game/
 */
public class _55_跳跃游戏_Y {
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int maxPos = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i <= maxPos) {
                int pos = i + nums[i];
                maxPos = Math.max(maxPos, pos);
                if (maxPos >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJump(arr));
    }
}
