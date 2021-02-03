package 二叉树;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 */
public class _450_删除二叉搜索树中的节点_Y {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 查找要删除的节点
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else { // 找到要删除的节点
            if (root.left == null && root.right == null) { // 叶子节点直接删除
                root = null;
            } else if (root.right != null) { // 右节点不为空
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else { // 左节点不为空
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    // 前驱节点
    private int predecessor(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }


    // 后继节点
    private int successor(TreeNode node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }
}

