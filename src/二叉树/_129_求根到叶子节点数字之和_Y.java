package 二叉树;

/**
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 */
public class _129_求根到叶子节点数字之和_Y {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int i) {
        if (node == null) {
            return 0;
        }
        int temp = 10 * i + node.val;
        if (node.left == null && node.right == null) {
            return temp;
        }
        return dfs(node.left, temp) + dfs(node.right, temp);
    }
}
