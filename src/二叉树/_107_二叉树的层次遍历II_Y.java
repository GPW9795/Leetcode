package 二叉树;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class _107_二叉树的层次遍历II_Y {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> row = new LinkedList<>();
        int levelSize = 1;
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelSize--;
            row.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (levelSize == 0) {
                levelSize = queue.size();
                list.add(row);
                row = new LinkedList<>();
            }
        }
        Collections.reverse(list);
        return list;
    }
}
