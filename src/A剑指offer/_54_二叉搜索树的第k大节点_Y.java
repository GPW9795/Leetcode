package A剑指offer;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class _54_二叉搜索树的第k大节点_Y {
    /**
     * 中序遍历得到结果
     */
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.addFirst(root.val);
            root = root.right;
        }
        return list.get(k - 1);
    }

    /**
     * 中序遍历倒序
     */
    public int kthLargest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int n = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            n++;
            if (n == k) {
                return root.val;
            }
            root = root.left;
        }
        return -1;
    }

    /**
     * 递归
     */
    int res, k;

    public int kthLargest2(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return res;
    }

    public void helper(TreeNode node) {
        if (node == null) return;
        helper(node.right);
        if (k == 0) return;
        if (--k == 0) res = node.val;
        helper(node.left);
    }
}
