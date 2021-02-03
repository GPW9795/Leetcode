package 链表;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 */
public class _328_奇偶链表_Y {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
