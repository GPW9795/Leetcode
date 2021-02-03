package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class _25_K个一组翻转链表_Y {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            ListNode tail = prev;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] arr = Reverse(head, tail);
            head = arr[0];
            tail = arr[1];
            prev.next = head;
            tail.next = next;
            prev = tail;
            head = tail.next;
        }
        return dummy.next;
    }

    private ListNode[] Reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode curr = head;
        while (prev != tail) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return new ListNode[]{tail, head};
    }
}
