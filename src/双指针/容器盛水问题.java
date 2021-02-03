package 双指针;

public class 容器盛水问题 {
    public long maxWater(int[] arr) {
        int n = arr.length;
        int leftMax = arr[0], rightMax = arr[n - 1];
        int left = 0, right = n - 1;
        long res = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, arr[left]);
            rightMax = Math.max(rightMax, arr[right]);
            if (leftMax < rightMax) {
                res += leftMax - arr[left];
                left++;
            } else {
                res += rightMax - arr[right];
                right--;
            }
        }
        return res;
    }
}
