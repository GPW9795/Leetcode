package 二叉树;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class _104_二叉树的最大深度_Y {
    /**
     * 递归实现
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 迭代实现
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int height = 0;
        int levelSize = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            levelSize--;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (levelSize == 0){
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }

}
