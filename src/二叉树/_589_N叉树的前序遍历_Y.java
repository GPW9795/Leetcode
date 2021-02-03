package 二叉树;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class _589_N叉树的前序遍历_Y {
    /**
     * 递归实现
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(Node node, List list) {
        if (node == null) {
            return;
        }
        list.add(node.val);

        for (int i = 0; i < node.children.size(); i++) {
            preOrder(node.children.get(i), list);
        }
    }

    /**
     * 迭代实现
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            Collections.reverse(node.children);
            for (int i = 0; i < node.children.size(); i++) {
                stack.push(node.children.get(i));
            }
        }
        return list;
    }
}
