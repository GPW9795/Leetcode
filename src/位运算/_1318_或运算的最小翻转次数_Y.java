package 位运算;

/**
 * https://leetcode-cn.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
 */
public class _1318_或运算的最小翻转次数_Y {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        while (c != 0 || a != 0 || b != 0) {
            int cv = c & 1;
            int av = a & 1;
            int bv = b & 1;
            c >>= 1;
            a >>= 1;
            b >>= 1;
            if ((av | bv) == cv) {
                continue;
            }
            if (cv == 1) {
                res++;
            } else {
                if (av == 1) {
                    res++;
                }
                if (bv == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
