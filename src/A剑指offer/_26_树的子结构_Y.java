package A剑指offer;

/**
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */
public class _26_树的子结构_Y {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean helper(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return helper(A.left, B.left) && helper(A.right, B.right);
    }
}
