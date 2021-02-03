package 二叉树;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class _106_从中序与后序遍历序列构造二叉树 {
    /**
     * 递归实现
     */
    private HashMap<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        indexMap = new HashMap<>();

        // 构建哈希映射提高效率
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return myBuildTree(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        if (postRight < postLeft) {
            return null;
        }
        // 后序遍历找到根节点
        int postRoot = postRight;
        // 中序遍历找到根节点
        int inRoot = indexMap.get(postorder[postRight]);
        // 构建根节点
        TreeNode root = new TreeNode(postorder[postRight]);
        // 得到左子树数量
        int leftTreeNum = inRoot - inLeft;
        // 构建左子树
        root.left = myBuildTree(inorder, postorder, inLeft, inRoot - 1, postLeft, postLeft + leftTreeNum - 1);
        // 构建右子树
        root.right = myBuildTree(inorder, postorder, inRoot + 1, inRight, postLeft + leftTreeNum, postRight - 1);
        // 返回根节点
        return root;
    }

    /**
     * 迭代实现
     */
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        return null;
    }
}
