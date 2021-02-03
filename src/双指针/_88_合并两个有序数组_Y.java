package 双指针;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class _88_合并两个有序数组_Y {
    /**
     * 双指针从左往右
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = nums1[i];
        }
        int li = 0, ri = 0;
        int ai = 0;
        while (li < m && ri < n) {
            if (nums2[ri] < nums[li]) {
                nums1[ai++] = nums2[ri++];
            } else {
                nums1[ai++] = nums[li++];
            }
        }
        if (li == m) {
            while (ri < n) {
                nums1[ai++] = nums2[ri++];
            }
        } else {
            while (li < m) {
                nums1[ai++] = nums[li++];
            }
        }
    }

    /**
     * 双指针从右往左
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int len = m + n - 1;
        while (p1 >= 0) {
            if (p2 >= 0 && nums2[p2] > nums1[p1]) {
                nums1[len--] = nums2[p2--];
            } else {
                nums1[len--] = nums1[p1--];
            }
        }
        while (p2 >= 0) {
            nums1[len--] = nums2[p2--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1, 2, 3};
        int n = 3;
        merge1(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
