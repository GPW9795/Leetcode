package 递归或回溯;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class _47_全排列II_Y {
    boolean[] visited;
    List<Integer> list;
    List<List<Integer>> result;
    int len;

    public List<List<Integer>> permuteUnique(int[] nums) {
        len = nums.length;
        result = new ArrayList<>();
        if (nums == null || len == 0) return result;
        visited = new boolean[len];
        list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0);
        return result;
    }

    /**
     * 回溯 + 剪枝
     */
    private void dfs(int[] nums, int depth) {
        if (depth == len) {
            result.add(new ArrayList<>(list));
        }
        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            list.add(nums[i]);
            visited[i] = true;

            dfs(nums, depth + 1);

            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2};
        System.out.println(new _47_全排列II_Y().permuteUnique(nums));
    }
}
