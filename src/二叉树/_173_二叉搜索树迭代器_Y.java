package 二叉树;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 */
public class _173_二叉搜索树迭代器_Y {
    int now = 0;
    ArrayList<Integer> list = new ArrayList();

    public _173_二叉搜索树迭代器_Y(TreeNode root) {
        inorder(root);
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return list.get(now++);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return now < list.size();
    }
}
