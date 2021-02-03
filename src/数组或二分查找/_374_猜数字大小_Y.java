package 数组或二分查找;

/**
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 */
public class _374_猜数字大小_Y {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == -1) {
                right = mid;
            } else if (guess(mid) == 1) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    /**
     * 假想方法
     */
    private int guess(int n) {
        return 0;
    }
}
