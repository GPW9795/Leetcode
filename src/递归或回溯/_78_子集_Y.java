package 递归或回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 */
public class _78_子集_Y {
    /**
     * 回溯法
     */
    List<List<Integer>> result;
    List<Integer> list;
    int len;

    public List<List<Integer>> subsets1(int[] nums) {
        len = nums.length;
        result = new ArrayList<>();
        list = new ArrayList<>();
        if (nums == null) return result;

        dfs(nums, 0);
        return result;
    }

    private void dfs(int[] nums, int begin) {
        result.add(new ArrayList<>(list));
        for (int i = begin; i < len; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 迭代 + 位运算
     */
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        list = new ArrayList<>();
        if (nums == null) return result;
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            list.clear();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }
            result.add(new ArrayList<>(list));
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(new _78_子集_Y().subsets(nums));
    }
}
