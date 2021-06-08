package A剑指offer;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */
public class _62_圆圈中最后剩下的数字 {
    /**
     * ArrayList勉强通过，LinkedList超时
     */
    public static int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    /**
     * 约瑟夫环问题
     */
    public static int lastRemaining1(int n, int m) {
        return 0;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        System.out.println(lastRemaining(n, m));
    }
}
