package 二叉树;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class _113_路径总和II_Y {
    private List<List<Integer>> res;
    private List<Integer> list;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        dfs(root, sum);
        return res;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        list.remove(list.size() - 1);
    }
}
