package 数组或二分查找;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class _4_寻找两个正序数组的中位数_Y {
    /**
     * 自己写的，时间复杂度为O(m + n)
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m + n];
        int index = 0, i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                arr[index++] = nums1[i++];
            } else {
                arr[index++] = nums2[j++];
            }
        }
        if (i == m) {
            for (int k = j; k < n; k++) {
                arr[index++] = nums2[k];
            }
        } else {
            for (int k = i; k < m; k++) {
                arr[index++] = nums1[k];
            }
        }
        System.out.println(Arrays.toString(arr));
        int mid = (m + n) >> 1;
        if (((m + n) & 1) == 0) { // 如果数组长度为偶数
            return (double) (arr[mid - 1] + arr[mid]) / 2;
        } else { // 如果数组长度为奇数
            return arr[mid];
        }
    }

    /**
     * 划分数组，i将nums1分为两部分，j将nums分为两部分
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        // 保证nums1的长度比nums2小
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays2(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        // 前一部分最小的值和后一部分最大的值
        int mid1 = 0, mid2 = 0;
        while (left <= right) {
            // i, j分别为划分区间
            int i = (left + right) >> 1;
            int j = (m + n + 1) / 2 - i;

            // 获得nums1[i - 1], nums1[i], nums2[j - 1], nums2[j]的值
            int Ai_1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int Ai = i == m ? Integer.MAX_VALUE : nums1[i];
            int Bj_1 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int Bj = j == n ? Integer.MAX_VALUE : nums2[j];

            if (Ai_1 <= Bj) {
                mid1 = Math.max(Ai_1, Bj_1);
                mid2 = Math.min(Ai, Bj);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return ((m + n) & 1) == 0 ? (mid1 + mid2) * 0.5 : mid1;
    }

    /**
     * 二分查找，每次寻找第k小的数，k为中间位置
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // 寻找第left小和第right小的数，这两个数的值即为中位数
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        if (left == right) { // 总数为奇数
            return findKNum(nums1, 0, m - 1, nums2, 0, n - 1, left);
        } else { // 总数为偶数
            return (findKNum(nums1, 0, m - 1, nums2, 0, n - 1, left) +
                    findKNum(nums1, 0, m - 1, nums2, 0, n - 1, right)) * 0.5;
        }
    }

    /**
     * 寻找两个数组合并后nums1[l1, r1]，nums2[l1, r2]，第k小的值，速度最快
     */
    private static int findKNum(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2, int k) {
        int len1 = r1 - l1 + 1;
        int len2 = r2 - l2 + 1;
        // 让len1一定小于len2，这样当数组为空时一定为len1
        if (len1 > len2) {
            return findKNum(nums2, l2, r2, nums1, l1, r1, k);
        }
        // 数组1为空时
        if (len1 == 0) {
            return nums2[l2 + k - 1];
        }
        // 寻找最小的直接返回两个数组中小的那个
        if (k == 1) {
            return Math.min(nums1[l1], nums2[l2]);
        }
        int i = l1 + Math.min(len1, k / 2) - 1;
        int j = l2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return findKNum(nums1, l1, r1, nums2, j + 1, r2, k - (j - l2 + 1));
        } else {
            return findKNum(nums1, i + 1, r1, nums2, l2, r2, k - (i - l1 + 1));
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 7};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
