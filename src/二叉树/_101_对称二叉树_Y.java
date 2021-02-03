package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class _101_对称二叉树_Y {
    /**
     * 递归实现
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    /**
     * 迭代实现
     */
    public boolean isSymmetric1(TreeNode root) {
        return check1(root, root);
    }

    public boolean check1(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode u = queue.poll();
            TreeNode v = queue.poll();
            if (u == null & v == null) {
                continue;
            }
            if ((u == null || v == null) || u.val != v.val){
                return false;
            }
            queue.offer(u.left);
            queue.offer(v.right);
            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
    }
}
