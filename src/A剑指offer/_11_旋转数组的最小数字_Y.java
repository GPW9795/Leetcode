package A剑指offer;

/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class _11_旋转数组的最小数字_Y {
    public int minArray(int[] numbers) {
        if (numbers.length == 0) return 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }
}
