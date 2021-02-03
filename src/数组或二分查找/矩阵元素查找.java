package 数组或二分查找;

import java.util.*;

public class 矩阵元素查找 {
    public static int[] findElement(int[][] mat, int n, int m, int x) {
        int nn = n - 1, mm = 0;
        while (nn >= 0 && mm < m) {
            if (mat[nn][mm] > x) {
                nn--;
            } else if (mat[nn][mm] < x) {
                mm++;
            } else {
                return new int[]{nn, mm};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}};
        int n = 2;
        int m = 3;
        int x = 6;
        System.out.println(Arrays.toString(findElement(mat, n, m, x)));
    }
}