package A剑指offer;

/**
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class _15_二进制中1的个数_Y {
    public static int hammingWeight(int n) {
        int flag = 1;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((flag & n) == flag) res++;
            flag <<= 1;
        }
        return res;
    }

    public static int hammingWeight1(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(hammingWeight(n));
    }
}
