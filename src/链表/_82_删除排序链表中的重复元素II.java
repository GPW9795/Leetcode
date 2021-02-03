package 链表;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class _82_删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        ListNode curr = head;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            prev.next = curr;
        }
        return head;
    }
}
