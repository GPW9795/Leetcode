package 数组或二分查找;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/fair-candy-swap/
 */
public class _888_公平的糖果棒交换_Y {
    public static int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int num = (sumA - sumB) >> 1;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }
        int[] res = new int[2];
        for (int b : B) {
            int a = b + num;
            if (set.contains(a)) {
                res[0] = a;
                res[1] = b;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 1};
        int[] B = {2, 2};
        System.out.println(Arrays.toString(fairCandySwap(A, B)));
    }
}
