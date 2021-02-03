package A剑指offer;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class _22_链表中倒数第k个节点_Y {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode p = head;
        ListNode q = head;
        while (q != null && k > 0) {
            q = q.next;
            k--;
        }
        if (q == null) return null;
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
