package 链表;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class _23_合并K个升序链表_Y {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (!queue.isEmpty()) {
            prev.next = queue.poll();
            prev = prev.next;
            if (prev.next != null) {
                queue.offer(prev.next);
            }
        }
        return dummy.next;
    }
}
