package 数组或二分查找;

/**
 * https://www.nowcoder.com/practice/7cd13986c79d4d3a8d928d490db5d707?tpId=190&&tqId=35352&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 */
public class 在转动过的有序数组中寻找目标值 {
    public int search(int[] A, int target) {
        int n = A.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] >= A[left]) {
                if (A[left] <= target && target < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
