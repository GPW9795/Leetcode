package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class _590_N叉树的后序遍历_Y {
    /**
     * 递归实现
     */
    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(Node node, List list) {
        if (node == null) {
            return;
        }
        for (Node item : node.children) {
            postOrder(item, list);
        }
        list.add(node.val);
    }

    /**
     * 迭代实现
     */
    public List<Integer> postorder1(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.addFirst(node.val);
            for (Node item : node.children) {
                stack.push(item);
            }
        }
        return list;
    }
}
