package A剑指offer;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 */
public class _55_I二叉树的深度_Y {
    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        return Math.max(left, right) + 1;

    }
}


