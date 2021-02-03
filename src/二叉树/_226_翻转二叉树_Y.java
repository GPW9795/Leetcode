package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class _226_翻转二叉树_Y {

    // 递归, 用前中后序遍历都可以
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // 前序遍历
    public TreeNode invertTreePreorder(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTreePreorder(root.left);
        invertTreePreorder(root.right);
        return root;
    }

    // 中序遍历
    public TreeNode invertTreeInorder(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTreeInorder(root.left);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTreeInorder(root.left);
        return root;
    }

    // 后序遍历
    public TreeNode invertTreePostorder(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTreePostorder(root.left);
        invertTreePostorder(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    // 层序遍历,迭代
    public TreeNode invertTreeLevelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

}
