package A剑指offer;

/**
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 */
public class _55_II_平衡二叉树_Y {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = depth(node.left);
        if (leftDepth == -1) return -1;
        int rightDepth = depth(node.right);
        if (rightDepth == -1) return -1;
        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : Math.max(leftDepth, rightDepth) + 1;
    }
}
