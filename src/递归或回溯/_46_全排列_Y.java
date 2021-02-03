package 递归或回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 */
public class _46_全排列_Y {
    boolean[] visited;
    int len = 0;
    List<List<Integer>> result;
    List<Integer> list;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        len = nums.length;
        if (nums == null || len == 0) return result;

        list = new ArrayList<>();
        visited = new boolean[len];
        dfs(nums, 0);
        return result;
    }

    private void dfs(int[] nums, int depth) {
        if (depth == len) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                dfs(nums, depth + 1);
                // 回溯
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new _46_全排列_Y().permute(nums));
    }
}
