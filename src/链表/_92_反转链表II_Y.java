package 链表;


/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class _92_反转链表II_Y {
    /**
     * 递归解决
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 当 m == 1 时，相当于是反转链表前n个元素
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 后继节点，即第 N + 1 个元素
     */
    ListNode successor = null;

    /**
     * 反转一个链表的前N个元素
     *
     * @param head 当前的链表头结点
     * @param N    从1开始反转前N个元素
     * @return 反转完成后新的头结点
     */
    private ListNode reverseN(ListNode head, int N) {
        if (N == 1) {
            successor = head.next;
            return head;
        }
        ListNode cur = reverseN(head.next, N - 1);
        head.next.next = head;
        head.next = successor;
        return cur;
    }

    /**
     * 迭代解决
     */
    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode cur = head;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode tail = cur;
        ListNode con = prev;

        ListNode tmp = null;
        while (n > 0) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            n--;
        }
        if (con != null) {
            con.next = prev;
        } else { // 从头结点开始反转
            head = prev;
        }
        tail.next = cur;
        return head;
    }

}
