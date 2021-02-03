package 二叉树;

/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class _938_二叉搜索树的范围和_Y {
    /**
     * 中序遍历，遇到节点值时开始计数，可以递归
     */
    int sum = 0;
    boolean flag = false;

    public int rangeSumBST(TreeNode root, int L, int R) {
        inorder(root, L, R);
        return sum;
    }

    private void inorder(TreeNode node, int L, int R) {
        if (node == null) {
            return;
        }
        inorder(node.left, L, R);
        if (node.val == L) {
            flag = true;
        }
        if (flag) {
            sum += node.val;
        }
        if (node.val == R) {
            flag = false;
        }
        inorder(node.right, L, R);
    }

    private void inorder1(TreeNode node, int L, int R) {
        if (node == null) {
            return;
        }
        inorder(node.left, L, R);
        if (node.val >= L && node.val <= R) {
            sum += node.val;
        }
        inorder1(node.right, L, R);
    }

    /**
     * dfs
     */
    public int rangeSumBST1(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return sum;
    }

    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R) {
                sum += node.val;
            }
            if (L < node.val) {
                dfs(node.left, L, R);
            }
            if (R > node.val) {
                dfs(node.right, L, R);
            }
        }
    }
}
