package 二叉树;

/**
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 */
public class _701_二叉搜索树中的插入操作_Y {
    /**
     * 迭代实现1
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null) {
            prev = curr;
            if (curr.val < val) {
                curr = curr.right;
            } else if (curr.val > val) {
                curr = curr.left;
            }
        }
        if (prev.val < val) {
            prev.right = new TreeNode(val);
        } else {
            prev.left = new TreeNode(val);
        }
        return root;
    }

    /**
     * 迭代实现2
     */
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val < val) {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    break;
                } else {
                    curr = curr.right;
                }

            } else {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    break;
                } else {
                    curr = curr.left;
                }
            }
        }
        return root;
    }

    /**
     * 递归实现
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
