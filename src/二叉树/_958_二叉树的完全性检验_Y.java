package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 */
public class _958_二叉树的完全性检验_Y {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode prev = root;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (prev == null && node != null) return false;
            prev = node;
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }
}
