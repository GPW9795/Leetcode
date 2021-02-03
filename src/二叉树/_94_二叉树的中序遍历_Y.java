package 二叉树;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class _94_二叉树的中序遍历_Y {
    /**
     * 递归实现
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode node, List list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    /**
     * 迭代实现
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> output = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            output.add(root.val);
            root = root.right;
        }
        return output;
    }
}
