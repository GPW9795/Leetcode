package 数组或二分查找;

/**
 * https://leetcode-cn.com/problems/reverse-pairs/
 */
public class _493_翻转对_Y {
    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return reversePairsRecursive(nums, 0, nums.length - 1);
    }

    private int reversePairsRecursive(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (left + right) >> 1;
            int rp1 = reversePairsRecursive(nums, left, mid);
            int rp2 = reversePairsRecursive(nums, mid + 1, right);
            int res = rp1 + rp2;
            int i = left;
            int j = mid + 1;
            while (i <= mid) {
                while (j <= right && (long) nums[i] > 2 * (long) nums[j]) j++;
                res += j - mid - 1;
                i++;
            }
            // 进行归并排序
            int[] sort = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int idx = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sort[idx++] = nums[p2++];
                } else if (p2 > right) {
                    sort[idx++] = nums[p1++];
                } else {
                    if (nums[p1] < nums[p2]) {
                        sort[idx++] = nums[p1++];
                    } else {
                        sort[idx++] = nums[p2++];
                    }
                }
            }
            // 复制给原数组
            for (int k = 0; k < sort.length; k++) {
                nums[k + left] = sort[k];
            }
            // 返回结果
            return res;
        }
    }
}
