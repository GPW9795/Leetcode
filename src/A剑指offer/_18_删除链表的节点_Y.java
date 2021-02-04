package A剑指offer;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class _18_删除链表的节点_Y {
    /**
     * 有虚拟头节点
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                break;
            } else {
                curr = curr.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }

    /**
     * 没有虚拟头节点
     */
    public ListNode deleteNode1(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val) return head.next;
        ListNode curr = head;
        while (curr.next != null && curr.next.val != val) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    /**
     * 递归
     */
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val) return head.next;
        head.next = deleteNode2(head.next, val);
        return head;
    }

}
