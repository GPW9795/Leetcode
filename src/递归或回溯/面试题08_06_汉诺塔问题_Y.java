package 递归或回溯;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/hanota-lcci/
 */
public class 面试题08_06_汉诺塔问题_Y {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    private void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        move(n - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        move(n - 1, B, A, C);
    }

    /**
     * 将n个碟子从p1 -> p3
     * 分2种情况讨论
     * （1）当n == 1时，直接从1 -> 3
     * （2）当n >= 1时，先将n - 1个盘子从1 -> 2;（递归）
     * 再将第n个盘子从1 -> 3;
     * 最后将n-1个盘子从2->3.（递归）
     */
//    public void haoni(int n, String p1, String p2, String p3) {
//        if (n == 1) {
//            move(1, p1, p3);
//            return;
//        }
//        haoni(n - 1, p1, p3, p2);
//        move(n, p1, p3);
//        haoni(n - 1, p2, p1, p3);
//    }
}
