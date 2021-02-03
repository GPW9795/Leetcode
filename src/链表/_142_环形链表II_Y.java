package 链表;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class _142_环形链表II_Y {
    /**
     * 快慢指针思想
     * 有环返回快慢指针相遇的节点，无环返回null
     * 假设从起点到入环节点的距离为F，从入环节点到相遇的节点距离为a，从相遇节点回到入环节点的距离为b
     * 2 * distance(slow) = distance(fast)
     * 2 * (F + a) = F + a + b + a
     * F = b
     * 所以此时设置一个指向head的节点，与快指针同步走，二者相遇的节点即为入环点
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode a = findCircle(head);
        if (a != null) {
            ListNode b = head;
            while (a != b) {
                a = a.next;
                b = b.next;
            }
            return a;
        }
        return null;
    }

    private ListNode findCircle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // 有环
                return slow;
            }
        }
        return null;
    }

    /**
     * 利用Set的唯一性
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
