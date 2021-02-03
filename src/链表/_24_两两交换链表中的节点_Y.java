package 链表;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class _24_两两交换链表中的节点_Y {
    /**
     * 迭代实现
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        ListNode sentinel = newHead;
        ListNode h1 = head;
        ListNode h2 = head.next;
        do {
            // 交换在链表中的位置
            h1.next = h2.next;
            h2.next = h1;
            sentinel.next = h2;
            // 交换指针
            ListNode tmp = h2;
            h2 = h1;
            h1 = tmp;
            // 继续后走
            h1 = h1.next.next;
            if (h1 == null) break;
            h2 = h2.next.next;
            if (h2 == null) break;
            sentinel = sentinel.next.next;
        } while (h2 != null);
        return newHead.next;
    }


    public ListNode swapPairs2(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        temp.next = head;
        while (temp.next != null && temp.next.next != null) {
            ListNode n1 = temp.next;
            ListNode n2 = temp.next.next;
            // 交换
            temp.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            // temp后移
            temp = n1;
        }
        return newHead.next;
    }

    /**
     * 递归实现
     */
    public ListNode swapPairs3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs3(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
