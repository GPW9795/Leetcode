package A剑指offer;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class _06_从尾到头打印链表_Y {
    public int[] reversePrint1(ListNode head) {
        if (head == null) return new int[0];
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.addFirst(head.val);
            head = head.next;
        }
        int n = list.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        int n = getLen(head);
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }

    public int getLen(ListNode head) {
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
