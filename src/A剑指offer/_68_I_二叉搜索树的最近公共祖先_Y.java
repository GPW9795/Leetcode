package A剑指offer;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class _68_I_二叉搜索树的最近公共祖先_Y {
    /**
     * 递归
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    /**
     * 迭代
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while (root != null) {
            if (root.val < p.val) {
                root = root.right;
            } else if (root.val > q.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }
}
