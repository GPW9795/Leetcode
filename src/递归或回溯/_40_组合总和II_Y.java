package 递归或回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class _40_组合总和II_Y {
    List<Integer> list;
    List<List<Integer>> result;
    int len;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        len = candidates.length;
        result = new ArrayList<>();
        if (candidates == null || len == 0) return result;

        list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return result;
    }

    private void dfs(int[] candidates, int begin, int target) {
        if (target <= 0) {
            if (target == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = begin; i < len; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                dfs(candidates, i + 1, target - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new _40_组合总和II_Y().combinationSum2(candidates, target));
    }
}
