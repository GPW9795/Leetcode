package 数组或二分查找;

/**
 * https://leetcode-cn.com/problems/first-bad-version/
 */
public class _278_第一个错误的版本_Y {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 假想
     */
    private boolean isBadVersion(int n) {
        return false;
    }
}
