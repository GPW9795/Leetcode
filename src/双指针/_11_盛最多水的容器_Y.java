package 双指针;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class _11_盛最多水的容器_Y {
    /**
     * 自己写的
     */
    public static int maxArea1(int[] height) {
        if (height == null || height.length == 0) return 0;
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        while (start < end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            maxArea = Math.max(area, maxArea);
            if (height[start] >= height[end]) {
                end--;
            } else {
                start++;
            }
        }
        return maxArea;
    }

    /**
     * 省略解法
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            maxArea = height[i] < height[j] ?
                    Math.max(maxArea, (j - i) * height[i++]) :
                    Math.max(maxArea, (j - i) * height[j--]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {6, 10, 8, 7, 3, 2};
        System.out.println(maxArea(height));
    }
}
