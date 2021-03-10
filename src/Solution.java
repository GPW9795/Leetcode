import java.util.Arrays;

public class Solution {
    public static void helper(int[][] a) {
        for (int i = 0; i < a.length; i++) { // 二维数组的长度
            for (int j = 0; j < a[i].length; j++) { // 每个一维数组的长度
                int n = j + 1;
                for (int m = i; m < a.length; m++) {
                    for (; n < a[i].length; n++) {
                        if (a[i][j] > a[m][n]) {
                            int min = a[m][n];
                            a[m][n] = a[i][j];
                            a[i][j] = min;
                        }
                    }
                    n = 0; // 此处是给n从第二个一维数组开始取0这个坐标
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.println(a[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] A = {{3, 1, 2}, {4, 1, 3}};
        helper(A);
    }
}