package 排序;


/**
 * https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class _147_对链表进行插入排序_Y {
    /**
     * 每次插入一个元素，时间复杂度为O(n^2)，空间复杂度为O(1)，主要是遍历链表的时间长
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 虚拟头结点，为方便从头部插入元素
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        // 已排序部分的最后一个节点
        ListNode lastNode = head;
        // 当前待插入的元素
        ListNode curr = head.next;
        while (curr != null) {
            // 如果最后一个节点比待插入元素的元素值小，则直接指向下一个元素
            if (lastNode.val <= curr.val) {
                lastNode = lastNode.next;
            } else { // 不然则需要遍历已排序好的链表，找到最后一个比curr值小的元素
                ListNode prev = dummyNode;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastNode.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastNode.next;
        }
        return dummyNode.next;
    }
}
