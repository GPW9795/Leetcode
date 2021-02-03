package 二叉树;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class _124_二叉树中的最大路径和_Y {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    public int maxSum(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, maxSum(root.left));
        int right = Math.max(0, maxSum(root.right));
        max = Math.max(max, Math.max(root.val + Math.max(left, right), root.val + left + right));
        return root.val + Math.max(left, right);
    }
}
