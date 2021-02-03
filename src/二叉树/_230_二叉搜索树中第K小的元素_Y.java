package 二叉树;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class _230_二叉搜索树中第K小的元素_Y {
    int myK = 1;
    int val = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return val;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null || myK > k) {
            return;
        }
        inorder(node.left, k);
        if (myK == k) {
            val = node.val;
        }
        myK++;
        inorder(node.right, k);
    }
}
