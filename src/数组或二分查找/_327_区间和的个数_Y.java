package 数组或二分查找;

/**
 * https://leetcode-cn.com/problems/count-of-range-sum/
 */
public class _327_区间和的个数_Y {
    /**
     * 暴力法
     */
    public int countRangeSum1(int[] nums, int lower, int upper) {
        int len = nums.length;
        if (len == 0) return 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            long sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum >= lower && sum <= upper) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 归并排序的思想
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0) return 0;
        long s = 0;
        long[] sum = new long[nums.length];
        // 得到前缀和数组
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            sum[i] += s;
        }
        return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
    }

    private int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
        if (left == right) {
            return sum[left] >= lower && sum[left] <= upper ? 1 : 0;
        }
        int mid = (left + right) >> 1;
        // 计算左边数组和右边数组满足条件的个数
        int r1 = countRangeSumRecursive(sum, lower, upper, left, mid);
        int r2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
        int res = r1 + r2;
        // 计算在两个数组中间符合条件的个数
        int i = left;
        int l = mid + 1;
        int r = mid + 1;
        while (i <= mid) {
            while (l <= right && sum[l] - sum[i] < lower) {
                l++;
            }
            while (r <= right && sum[r] - sum[i] <= upper) {
                r++;
            }
            res += r - l;
            i++;
        }
        // 对左右两边的数组进行合并从而方便下一次的递归
        int p = 0;
        long[] sorted = new long[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid || p2 <= right) {
            if (p1 > mid) {
                sorted[p++] = sum[p2++];
            } else if (p2 > right) {
                sorted[p++] = sum[p1++];
            } else {
                if (sum[p1] < sum[p2]) {
                    sorted[p++] = sum[p1++];
                } else {
                    sorted[p++] = sum[p2++];
                }
            }
        }
        // 赋值为原数组
        for (int j = 0; j < sorted.length; j++) {
            sum[left + j] = sorted[j];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 1};
        int lower = 0;
        int upper = 0;
        System.out.println(new _327_区间和的个数_Y().countRangeSum(nums, lower, upper));
    }
}
