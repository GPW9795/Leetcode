package 二叉树;

/**
 * https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 */
public class _426_将二叉搜索树转化为排序的双向链表_Y {
    Node1 head = null;
    Node1 prev = null;

    public Node1 treeToDoublyList(Node1 root) {
        if (root == null) return null;
        helper(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    public void helper(Node1 node) {
        if (node == null) return;
        helper(node.left);
        if (prev != null) {
            prev.right = node;
            node.left = prev;
        } else {
            head = node;
        }
        prev = node;
        helper(node.right);
    }
}
