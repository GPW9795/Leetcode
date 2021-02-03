package 链表;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class _19_删除链表的倒数第N个节点_Y {
    /**
     * 可以反转链表后删除再反转
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 反转链表
        head = reverseList(head);
        // 删除第n个节点
        int index = 1;
        ListNode node = head;
        ListNode prev = null;
        while (index++ < n) {
            prev = node;
            node = node.next;
        }
        if (prev == null) {
            head = head.next;
        } else {
            prev.next = node.next;
            node.next = null;
        }
        // 再次反转
        head = reverseList(head);
        return head;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    /**
     * 使用双指针和哨兵，p、q之间间隔n个元素，依次后移，当q为null，p为要删节点的前一个节点
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode p = dummyNode;
        ListNode q = dummyNode;
        for (int i = 0; i <= n; i++) {
            p = p.next;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return dummyNode.next;
    }
}
