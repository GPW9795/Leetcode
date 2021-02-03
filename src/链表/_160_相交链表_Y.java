package 链表;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class _160_相交链表_Y {
    /**
     * Set的唯一性
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null || headB != null) {
            if (headA == headB) {
                return headA;
            }
            if (set.contains(headA) || set.contains(headB)) {
                return set.contains(headA) ? headA : headB;
            }
            if (headA != null) {
                set.add(headA);
                headA = headA.next;
            }
            if (headB != null) {
                set.add(headB);
                headB = headB.next;
            }
        }
        return null;
    }

    /**
     * 双指针法，定义pA指向A链表的头部，pB指向B链表的头部，二者一起往后走
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        // 判断条件不能写pA.next == null因为不相交时永远不会为空
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
