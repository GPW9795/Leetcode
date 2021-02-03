package A剑指offer;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 */
public class _36_二叉搜索树与双向链表_Y {
    Node first = null;
    Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        solve(root);
        first.left = last;
        last.right = first;
        return first;
    }

    public void solve(Node node) {
        if (node == null) return;
        solve(node.left);
        if (last != null) {
            last.right = node;
            node.left = last;
        } else {
            first = node;
        }
        last = node;
        solve(node.right);
    }
}
