package 链表;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class _234_回文链表_Y {
    /**
     * 将值复制到数组链表中再进行比较
     */
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size(); i++) {
            // 不能直接"=="因为是Integer类型，只有重新赋值才会自动开箱
            if (!list.get(i).equals(list.get(list.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 快慢指针找到中点后反转后半部分链表，从头和中点开始比较
     */
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode midNode = findMidNode(head);
        ListNode newHead = reverseList(midNode);
        while (newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }

        return true;
    }

    // 找到中间节点
    public ListNode findMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == null ? slow : slow.next;
    }

    // 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode node = head;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = newHead;
            newHead = node;
            node = tmp;
        }
        return newHead;
    }
}
