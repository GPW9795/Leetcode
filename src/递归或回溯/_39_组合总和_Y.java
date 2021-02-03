package 递归或回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class _39_组合总和_Y {
    List<Integer> list;
    List<List<Integer>> result;
    int len;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        len = candidates.length;
        if (candidates == null || len == 0) return result;

        list = new ArrayList<>();
        Arrays.sort(candidates);
        sum(candidates, 0, 0, target);
        return result;
    }

    private void sum(int[] candidates, int begin, int sum, int target) {
        if (sum >= target) {
            if (sum == target) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        // 注意起始位置
        for (int i = begin; i < len; i++) {
            if (candidates[i] <= (target - sum)) {
                list.add(candidates[i]);
                sum += candidates[i];
                sum(candidates, i, sum, target);
                sum -= list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new _39_组合总和_Y().combinationSum(candidates, target));
    }
}
