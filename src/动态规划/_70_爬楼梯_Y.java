package 动态规划;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class _70_爬楼梯_Y {
    /**
     * 类似斐波那契数列
     */
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 优化，非递归
     */
    public static int climbStairs1(int n) {
        if (n <= 2) return n;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }

    public static void main(String[] args) {
        int n = 45;
        System.out.println(climbStairs1(n));
    }
}
