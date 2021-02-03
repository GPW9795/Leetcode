package 排序;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
public class _1365_有多少小于当前数字的数字_Y {
    /**
     * 暴力法
     */
    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) return null;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i || nums[j] >= nums[i]) continue;
                res[i]++;
            }
        }
        return res;
    }

    /**
     * 计数排序
     * 因为数组中的元素值在[0, 100]之间，符合计数排序的用法，在一定范围内对整数进行排序
     */
    public static int[] smallerNumbersThanCurrent2(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) return null;
        // 计数排序数组及初始化
        int[] cs = new int[101];
        for (int i = 0; i < n; i++) {
            cs[nums[i]]++;
        }
        for (int i = 1; i < 101; i++) {
            cs[i] += cs[i - 1];
        }
        // 每个数
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[i] == 0 ? 0 : cs[nums[i] - 1];
        }
        return res;
    }

    /**
     * 排序.快速排序
     */
    public static int[] smallerNumbersThanCurrent3(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) return null;
        int[] res = new int[n];
        // 记录每个元素的位置以及元素信息
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        // 将二维数组按照第一个元素由大到小排序
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 每个元素的最终值
        int prev = -1;
        for (int i = 0; i < n; i++) {
            // 最开始prev==0，之后如果元素不等于前一个元素才会更新为i
            if (prev == -1 || data[i][0] != data[i - 1][0]) {
                prev = i;
            }
            res[data[i][1]] = prev;
        }
        return res;
    }

    /**
     * 哈希表
     */
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) return null;
        int[] res = Arrays.copyOf(nums, nums.length);
        HashMap<Integer, Integer> map = new HashMap<>();
        // 排序.快速排序
        Arrays.sort(res);
        // 如果哈希表中已存在该元素说明重复则不需要更新i
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(res[i])) {
                map.put(res[i], i);
            }
        }
        for (int i = 0; i < n; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        int[] res = smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(res));
    }
}
