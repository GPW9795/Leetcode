package 二叉树;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class _105_从前序与中序遍历序列构造二叉树_Y {
    /**
     * 递归实现
     */
    private HashMap<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        // 哈希映射可以快速找到根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        // 前序遍历中定位根节点
        int preRoot = preLeft;
        // 中序遍历中定位根节点
        int inRoot = indexMap.get(preorder[preLeft]);
        // 建立根节点
        TreeNode root = new TreeNode(preorder[preLeft]);
        // 确定左子树的数量
        int leftTreeNum = inRoot - inLeft;
        // 递归构建左子树
        root.left = myBuildTree(preorder, inorder, preLeft + 1, preLeft + leftTreeNum, inLeft, inRoot - 1);
        // 递归构建右子树
        root.right = myBuildTree(preorder, inorder, preLeft + leftTreeNum + 1, preRight, inRoot + 1, inRight);
        // 构建完成，返回根节点
        return root;
    }

    /**
     * 迭代实现
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        // 表示当前遍历的下标
        int pre = 0;
        int in = 0;
        // 建栈保存每个遍历的节点
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[pre]);
        TreeNode curr = root;
        stack.push(curr);
        pre++;
        while (pre < preorder.length) {
            // 每次进行出栈，实现倒着遍历
            if (curr.val == inorder[in]) {
                while (!stack.isEmpty() && stack.peek().val == inorder[in]) {
                    curr = stack.pop();
                    in++;
                }
                // 更新右孩子
                curr.right = new TreeNode(preorder[pre]);
                // 更新当前curr
                curr = curr.right;
                stack.push(curr);
                pre++;

            } else {
                // 否则就一直作为左子树
                curr.left = new TreeNode(preorder[pre]);
                curr = curr.left;
                stack.push(curr);
                pre++;
            }
        }
        return root;
    }

}
