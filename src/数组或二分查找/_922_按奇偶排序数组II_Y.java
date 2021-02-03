package 数组或二分查找;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 */
public class _922_按奇偶排序数组II_Y {
    /**
     * 一次遍历
     */
    public static int[] sortArrayByParityII1(int[] A) {
        int evenI = 0;
        int oddI = 1;
        int len = A.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if ((A[i] & 1) == 0) { // 偶数
                res[evenI] = A[i];
                evenI += 2;
            } else {
                res[oddI] = A[i];
                oddI += 2;
            }
        }
        return res;
    }

    /**
     * 双指针1
     */
    public static int[] sortArrayByParityII2(int[] A) {
        // 指向第一个和第二个，如果有不符合的交换位置
        int i = 0; // 偶指针
        int j = 1; // 奇指针
        int len = A.length;
        while (i < len && j < len) {
            if ((A[i] & 1) == 0 && (A[j] & 1) == 1) { // 符合条件指针后移
                i += 2;
                j += 2;
            } else if ((A[i] & 1) != 0 && (A[j] & 1) != 1) { // 都不符合条件，交换位置
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                i += 2;
                j += 2;
            } else { // 有一个不符合条件
                if ((A[i] & 1) != 0) {
                    j += 2;
                } else {
                    i += 2;
                }
            }
        }
        return A;
    }

    /**
     * 双指针2
     */
    public static int[] sortArrayByParityII3(int[] A) {
        int len = A.length;
        int j = 1; // 奇指针
        for (int i = 0; i < len; i += 2) {
            if ((A[i] & 1) == 1) { // 偶指针处为奇数
                while (j < len) { // 挪动奇指针直到遇到奇指针处为偶数
                    if ((A[j] & 1) == 0) {
                        swap(A, i, j);
                        break;
                    }
                    j += 2;
                }
            }
        }
        return A;
    }

    /**
     * 双指针3
     */
    public static int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int j = 1; // 奇指针
        for (int i = 0; i < len; i += 2) {
            if ((A[i] & 1) == 1) { // 偶指针处为奇数
                while ((A[j] & 1) == 1) { // 挪动奇指针直到遇到奇指针处为偶数
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(sortArrayByParityII(A)));
    }
}
