package 位运算;

/**
 * https://leetcode-cn.com/problems/single-number/
 */
public class _136_只出现一次的数字_Y {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
