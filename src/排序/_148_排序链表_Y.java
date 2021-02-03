package 排序;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 */
public class _148_排序链表_Y {
    /**
     * 优先级队列
     */
    public ListNode sortList2(ListNode head) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ListNode node = head;
        while (node != null) {
            queue.offer(node.val);
            node = node.next;
        }
        node = head;
        while (node != null) {
            node.val = queue.poll();
            node = node.next;
        }
        return head;
    }

    /**
     * 排序.快速排序
     */
    public ListNode sortList1(ListNode head) {
        ListNode node = head;
        ArrayList<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        node = head;
        int index = 0;
        while (node != null) {
            node.val = list.get(index++);
            node = node.next;
        }
        return head;
    }

    /**
     * 排序.归并排序(递归），并不符合空间复杂度常量级的要求
     */
    public ListNode sortList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMidNode(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        left = sortList3(left);
        right = sortList3(right);
        return mergeList1(left, right);
    }

    /**
     * 找到中点
     */
    private ListNode findMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 合并两个有序链表
     */
    private ListNode mergeList1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode newHead = new ListNode(0);
        ListNode prev = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return newHead.next;
    }

    /**
     * 排序.归并排序，符合常数级空间复杂度的操作
     * 不能递归合并，只能进行断链操作之后合并
     * 从step = 1开始，两个排序完成之后，step=2*step...以此类推
     */
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        int len = getLength(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int step = 1; step <= len; step *= 2) {
            ListNode prev = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode h1 = cur;
                ListNode h2 = split(cur, step);
                cur = split(h2, step);
                ListNode newHead = mergeList(h1, h2);
                prev.next = newHead;
                while (prev.next != null) {
                    prev = prev.next;
                }

            }
        }
        return dummy.next;
    }

    /**
     * 获取链表长度
     */
    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     * 断链操作
     */
    private ListNode split(ListNode head, int step) {
        if (head == null) return null;
        ListNode cur = head;
        for (int i = 1; i < step && cur.next != null; i++) {
            cur = cur.next;
        }
        ListNode right = cur.next;
        cur.next = null;
        return right;

    }

    /**
     * 合并两个有序链表
     */
    private ListNode mergeList(ListNode h1, ListNode h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        ListNode newHead = new ListNode(0);
        ListNode prev = newHead;
        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                prev.next = h1;
                h1 = h1.next;
            } else {
                prev.next = h2;
                h2 = h2.next;
            }
            prev = prev.next;
        }
        prev.next = h1 == null ? h2 : h1;
        return newHead.next;
    }
}
