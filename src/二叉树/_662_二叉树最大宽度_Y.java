package 二叉树;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 */
public class _662_二叉树最大宽度_Y {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<Node> queue = new LinkedList<>();
        int maxWidth = 0;
        queue.offer(new Node(root, 1));

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Node first = queue.peekFirst();
            Node last = queue.peekLast();
            int width = last.pos - first.pos + 1;
            maxWidth = Math.max(maxWidth, width);
            while (levelSize-- > 0) {
                Node node = queue.poll();
                if (node.node.left != null) {
                    queue.offer(new Node(node.node.left, 2 * node.pos));
                }
                if (node.node.right != null) {
                    queue.offer(new Node(node.node.right, 2 * node.pos + 1));
                }
            }

        }
        return maxWidth;
    }

    class Node extends TreeNode {
        int pos;
        TreeNode node;

        public Node(TreeNode node, int pos) {
            this.pos = pos;
            this.node = node;
        }
    }
}
