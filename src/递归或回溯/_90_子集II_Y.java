package 递归或回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 */
public class _90_子集II_Y {
    List<List<Integer>> result;
    List<Integer> list;
    int len;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        len = nums.length;
        result = new ArrayList<>();
        if (nums == null) return result;
        list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0);
        return result;
    }

    private void dfs(int[] nums, int begin) {
        result.add(new ArrayList<>(list));
        for (int i = begin; i < len; i++) {
            if (i > begin && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(new _90_子集II_Y().subsetsWithDup(nums));
        System.out.println(1<<2);
    }
}
