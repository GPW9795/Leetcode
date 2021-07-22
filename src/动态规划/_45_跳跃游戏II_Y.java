package 动态规划;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 */
public class _45_跳跃游戏II_Y {
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int res = 0;
        int maxPos = 0;
        int end = 0;
        for (int i = 0; i < len - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump(arr));
    }
}
