package 链表;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class _237_删除链表中的节点_Y {

    // 因为给的是当前节点，所以可以先用下一个节点的值赋给当前节点，然后删除下一个节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


}

