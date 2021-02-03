package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class _222_完全二叉树的节点个数_Y {
    /**
     * 1、BFS，但效率太低
     */
    public int countNodes1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int n = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            n++;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return n;
    }

    /**
     * 2、递归
     */
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }

    /**
     * 3、根据完全二叉树的性质遍历
     */
    public int countNodes3(TreeNode root) {
        if (root == null) return 0;
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        // 如果左右子树高度相同，说明左子树为满二叉树，右子树可能不满，再递归调用计算右子树
        if (left == right) {
            return countNodes3(root.right) + (1 << left);
        } else { // 如果高度不同，说明右子树为满二叉树，递归调用左子树计算
            return countNodes3(root.left) + (1 << right);
        }
    }

    private int countLevel(TreeNode node) {
        // 计算完全二叉树的深度，一直遍历左子树得到深度
        int level = 0;
        while (node != null) {
            level++;
            node = node.left;
        }
        return level;
    }

    /**
     * 4、二分查找 + 位运算
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        // 倒数第二层的深度
        int depth = countLevel(root) - 1;
        int start = 1;
        int end = (1 << depth);
        int mid = 0;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (isExist(root, mid, depth)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // 最后一层叶子结点的数量
        return (1 << depth) - 1 + end;
    }

    /**
     * 判断在当前完全二叉树中此节点是否存在
     *
     * @param root  根节点
     * @param index 当前节点的标号
     * @param depth 倒数第二层的高度
     */
    private boolean isExist(TreeNode root, int index, int depth) {
        TreeNode node = root;
        while (depth != 0) {
            int mid = ((1 << depth) >> 1);
            if (mid < index) {
                index -= mid;
                node = node.right;
            } else {
                node = node.left;
            }
            depth--;
        }
        return node != null;
    }
}
