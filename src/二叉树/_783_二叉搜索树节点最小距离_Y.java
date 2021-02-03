package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
public class _783_二叉搜索树节点最小距离_Y {
    /**
     * 迭代中序遍历求最小值
     */
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return 0;
        }

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

        int minDiff = 99;
        for (int i = 0; i < list.size() - 1; i++) {
            minDiff = Math.min(list.get(i + 1) - list.get(i), minDiff);
        }
        return minDiff;
    }

    /**
     * 递归中序遍历求最小值
     */
    Integer prev = null;
    Integer ans = Integer.MAX_VALUE;

    public int minDiffInBST1(TreeNode root) {
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (prev != null) {
            ans = Math.min(node.val - prev, ans);
        }
        prev = node.val;
        inorder(node.right);
    }
}
