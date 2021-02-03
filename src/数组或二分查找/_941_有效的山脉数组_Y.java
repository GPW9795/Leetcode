package 数组或二分查找;

/**
 * https://leetcode-cn.com/problems/valid-mountain-array/
 */
public class _941_有效的山脉数组_Y {
    /**
     * 线性扫描
     */
    public boolean validMountainArray(int[] A) {
        int len = A.length;
        if (len < 3) return false;
        int i = 0;
        while (i < len - 1 && A[i] < A[i + 1]) {
            i++;
        }
        // 跳出循环时的i为峰值
        if (i == 0 || i == len - 1) return false;
        while (i < len - 1 && A[i] > A[i + 1]) {
            i++;
        }
        return i == len - 1;
    }

    /**
     * 双指针
     */
    public boolean validMountainArray1(int[] A) {
        int len = A.length;
        if (len < 3) return false;
        int i = 0, j = len - 1;
        // 寻找左侧峰值
        while (i < len - 1 && A[i] < A[i + 1]) {
            i++;
        }
        if (i == 0 || i == len - 1) return false;
        // 寻找右侧峰值
        while (j > 0 && A[j] < A[j - 1]) {
            j--;
        }
        return i == j;
    }
}
