package 二叉树;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class _297_二叉树的序列化与反序列化_Y {
    /**
     * DFS，采用前序遍历
     */
    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        if (root == null) return "X";
        String left = serialize1(root.left);
        String right = serialize1(root.right);
        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        String[] arr = data.split(",");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(arr));
        return helper(list);
    }

    public TreeNode helper(LinkedList<String> list) {
        String str = list.poll();
        if (str.equals("X")) return null;
        int num = Integer.valueOf(str);
        TreeNode root = new TreeNode(num);
        root.left = helper(list);
        root.right = helper(list);
        return root;
    }

    /**
     * BFS
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "X";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("X,");
            } else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if (arr[0] == "X") return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String leftVal = arr[index];
            String rightVal = arr[index + 1];
            if (!leftVal.equals("X")) {
                TreeNode left = new TreeNode(Integer.valueOf(arr[index]));
                queue.offer(left);
                node.left = left;
            }
            if (!rightVal.equals("X")) {
                TreeNode right = new TreeNode(Integer.valueOf(arr[index + 1]));
                queue.offer(right);
                node.right = right;
            }
            index += 2;
        }
        return root;
    }
}
