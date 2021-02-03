package A剑指offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 */
public class _07_重建二叉树_Y {
    /**
     * 递归
     */
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) return null;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    public TreeNode helper(int[] preorder, int pL, int pR, int[] inorder, int iL, int iR) {
        if (pL > pR) return null;
        int preRoot = pL;
        int inRoot = map.get(preorder[preRoot]);
        TreeNode root = new TreeNode(preorder[preRoot]);
        int leftNum = inRoot - iL;
        root.left = helper(preorder, pL + 1, pL + leftNum, inorder, iL, inRoot - 1);
        root.right = helper(preorder, pL + leftNum + 1, pR, inorder, inRoot + 1, iR);
        return root;
    }

    /**
     * 迭代
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) return null;
        int pre = 0, in = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[pre]);
        stack.push(root);
        TreeNode curr = root;
        pre++;
        while (pre < n) {
            if (curr.val == inorder[in]) {
                while (!stack.isEmpty() && stack.peek().val == inorder[in]){
                    curr = stack.pop();
                    in++;
                }
                curr.right = new TreeNode(preorder[pre]);
                curr = curr.right;
                stack.push(curr);
                pre++;

            } else {
                curr.left = new TreeNode(preorder[pre]);
                curr = curr.left;
                stack.push(curr);
                pre++;
            }
        }
        return root;
    }
}
