package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class _559_N叉树的最大深度_Y {
    /**
     * 递归实现
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 1;
        for (Node item : root.children) {
            int depth = 1 + maxDepth(item);
            if (depth > maxDepth) {
                maxDepth = depth;
            }
        }
        return maxDepth;
    }

    /**
     * 迭代实现
     */
    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        int levelSize = 1;
        int height = 0;
        queue.offer(root);
        while (root != null) {
            root = queue.poll();
            levelSize--;
            if (root != null) {
                for (Node item : root.children) {
                    queue.offer(item);
                }
            }
            if (levelSize == 0) {
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }
}
