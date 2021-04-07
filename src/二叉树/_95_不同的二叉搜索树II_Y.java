package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 */
public class _95_不同的二叉搜索树II_Y {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    /**
     * 生成数字从start到end的所有二叉搜索树的列表
     */
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            // 左右子树为空
            list.add(null);
            return list;
        }
        // 计算以i为根节点的所有树，i属于[start, end]
        for (int i = start; i <= end; i++) {
            // root所有左子树的列表
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            // root所有右子树的列表
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            // 双层循环遍历将根节点插入
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i, left, right);
                    list.add(root);
                }
            }
        }
        return list;
    }
}
