package 二叉树;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class _99_恢复二叉搜索树_Y {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null, x = null, y = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && prev.val > root.val) {
                y = root;
                if (x == null) {
                    x = prev;
                } else {
                    break;
                }
            }
            prev = root;
            root = root.right;
        }
        swap(x, y);
    }

    private void swap(TreeNode n1, TreeNode n2) {
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
}
