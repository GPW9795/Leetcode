package 链表;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class _2_两数相加_Y {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 新链表的头指针
        ListNode newHead = new ListNode(0);
        ListNode prev = newHead;
        int flag = 0;
        int sum = 0;
        while (l1 != null || l2 != null) {
            // 新节点的值
            if (l1 == null) {
                sum = l2.val + flag;
            } else if (l2 == null) {
                sum = l1.val + flag;
            } else {
                sum = l1.val + l2.val + flag;
            }
            flag = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            // 创建新节点
            prev.next = new ListNode(sum);
            // 前一节点的next指向新节点
            prev = prev.next;
            // l1、l2往前移
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        // 如果最后相加有进位
        if (flag == 1) {
            prev.next = new ListNode(1);
        }
        return newHead.next;
    }
}
