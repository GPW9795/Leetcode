package 集合;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class _349_两个数组的交集_Y {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> array = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                array.add(nums2[i]);
            }
        }
        int length = nums1.length > nums2.length ? nums2.length : nums1.length;
        int[] nums = new int[length];
        int index = 0;
        for (Integer s : array) {
            nums[index++] = s;
        }
        return Arrays.copyOf(nums, index);
    }

    /**
     * 排序 + 双指针
     */
    public static int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return new int[0];
        if (nums2 == null || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int idx1 = 0, idx2 = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] > nums2[idx2]) {
                idx2++;
            } else if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else {
                set.add(nums1[idx1]);
                idx1++;
                idx2++;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (int i : set) {
            res[index] = i;
            index++;
        }
        return res;
    }
}
