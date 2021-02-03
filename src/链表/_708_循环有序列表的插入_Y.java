package 链表;

/**
 * https://leetcode-cn.com/problems/insert-into-a-sorted-circular-linked-list/
 */
public class _708_循环有序列表的插入_Y {
    public Node insert(Node head, int insertVal) {
        // 链表为空的情况
        if (head == null) {
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }
        Node prev = head;
        Node curr = head.next;
        // 遍历链表找出最小节点及前驱节点，因为需要先进行循环所以使用do-while
        boolean insert = false;
        do {
            if (prev.val <= insertVal && curr.val >= insertVal) { // 新插入的节点的值在prev和curr之间
                insert = true;
            } else if (prev.val > curr.val) {
                if (prev.val < insertVal || curr.val > insertVal) { // 新插入节点的值小于或大于全部链表节点
                    insert = true;
                }
            }
            if (insert) { // 进行插入
                prev.next = new Node(insertVal, curr);
                return head;
            }
            prev = curr;
            curr = curr.next;
        } while (prev != head);
        // 如果链表中所有值相同，则最后直接插入任意位置即可
        prev.next = new Node(insertVal, curr);
        return head;
    }
}
