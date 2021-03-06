package 位运算;

/**
 * https://leetcode-cn.com/problems/hamming-distance/
 */
public class _461_汉明距离_Y {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int num = x ^ y;
        while (num != 0) {
            res += num & 1;
            num >>= 1;
        }
        return res;
    }

    /**
     * 内置运算
     */
    public int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
