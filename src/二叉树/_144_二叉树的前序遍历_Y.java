package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class _144_二叉树的前序遍历_Y {
    /**
     * 递归实现
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(TreeNode node, List list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }

    /**
     * 迭代实现
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();

        if (root == null){
            return null;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            list.add(node.val);
            if (node.right!=null){
                stack.add(node.right);
            }
            if (node.left!= null){
                stack.add(node.left);
            }
        }
        return list;
    }
}
