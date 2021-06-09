package A剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */
public class _34_二叉树中和为某一值的路径_Y {
    public List<List<Integer>> res;
    public List<Integer> list;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode node, int target) {
        if (node == null) return;
        list.add(node.val);
        target -= node.val;
        if (node.left == null && node.right == null) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }
        dfs(node.left, target);
        dfs(node.right, target);
        list.remove(list.size() - 1);
    }
}
