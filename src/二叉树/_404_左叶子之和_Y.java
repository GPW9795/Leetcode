package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class _404_左叶子之和_Y {
    /**
     * 递归
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return sumOfLeftLeaves(root.left)
                + sumOfLeftLeaves(root.right)
                + ((root.left != null && root.left.left == null && root.left.right == null) ? root.left.val : 0);
    }

    /**
     * 迭代,DFS
     */
    public int sum(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        int ans = 0;
        if (root == null) return 0;
        if (root.left != null) {
            ans += isLeaf(root.left) ? root.left.val : dfs(root.left);
        }
        if (root.right != null && !isLeaf(root.right)) {
            ans += dfs(root.right);
        }
        return ans;
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    /**
     * BFS
     */
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeaf(node.left)) {
                    ans += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null && !isLeaf(node.right)) {
                queue.offer(node.right);
            }
        }
        return ans;
    }
}
