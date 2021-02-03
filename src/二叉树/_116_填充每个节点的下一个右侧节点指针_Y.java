package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class _116_填充每个节点的下一个右侧节点指针_Y {
    /**
     * 层序遍历的方法
     */
    public Node1 connect(Node1 root) {
        if (root == null) return null;
        Queue<Node1> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node1 node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    /**
     * 使用已建立的next指针
     */
    public Node1 connect1(Node1 root) {
        if (root == null) return null;
        Node1 leftMost = root;
        while (leftMost.left != null) {
            Node1 node = leftMost;
            while (node != null) {
                //第一种连接情况
                node.left.next = node.right;
                //第二种连接情况
                if (node.next != null) {
                    node.right.next = node.next.left;
                }
                node = node.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    /**
     * 递归实现
     */
    public Node1 connect2(Node1 root) {
        if (root == null || root.left == null) return root;
        root.left.next = root.right;
        root.right.next = root.next == null ? null : root.next.left;
        root.left = connect2(root.left);
        root.right = connect2(root.right);
        return root;
    }
}
