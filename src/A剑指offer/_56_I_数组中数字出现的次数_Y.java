package A剑指offer;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
public class _56_I_数组中数字出现的次数_Y {
    /**
     * 利用Set
     */
    public static int[] singleNumbers1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int[] res = new int[2];
        int index = 0;
        for (int i : set) {
            res[index++] = i;
        }
        return res;
    }

    /**
     * 分组异或
     */
    public static int[] singleNumbers(int[] nums) {
        // 异或除去相同的数
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }

        // 获取这两个数字不一样的一位
        int mask = 1;
        while ((k & mask) == 0) {
            mask <<= 1;
        }

        // 根据mask进行分组
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 4, 6};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }
}
