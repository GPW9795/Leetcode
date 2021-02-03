package 二叉树;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class _700_二叉搜索树中的搜索_Y {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val < val) {
                curr = curr.right;
            } else if (curr.val > val) {
                curr = curr.left;
            } else {
                return curr;
            }
        }
        return null;
    }
}
