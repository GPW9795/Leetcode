package A剑指offer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 */
public class _37_序列化二叉树_Y {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "X";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(arr));
        return helper(list);
    }

    public TreeNode helper(LinkedList<String> list) {
        String s = list.poll();
        if (s.equals("X")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helper(list);
        root.right = helper(list);
        return root;
    }
}
