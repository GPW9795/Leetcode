package 设计;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * 双向链表和哈希表相结合
 */
public class _146_LRU缓存机制_Y {
    /**
     * 双向链表的节点
     */
    private class DoubleLinkNode {
        int key;
        int val;
        DoubleLinkNode prev;
        DoubleLinkNode next;

        public DoubleLinkNode() {
        }

        public DoubleLinkNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * 哈希表和双向链表结合
     */
    private HashMap<Integer, DoubleLinkNode> map = new HashMap<>();
    /**
     * 头节点和尾节点
     */
    private DoubleLinkNode head, tail;
    /**
     * 元素个数
     */
    private int size;
    /**
     * 容量
     */
    private int capacity;

    public _146_LRU缓存机制_Y(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleLinkNode();
        tail = new DoubleLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        DoubleLinkNode node = map.get(key);
        if (node == null) { // 新插入的
            node = new DoubleLinkNode(key, value);
            map.put(key, node);
            addFirst(node);
            size++;
            if (size > capacity) {// 达到容量需删除
                DoubleLinkNode removeNode = removeTail();
                map.remove(removeNode.key);
                size--;
            }
        } else { // 已经存在直接改值并插入到头部
            node.val = value;
            moveToFirst(node);
        }
    }

    /**
     * 在链表头部插入
     */
    private void addFirst(DoubleLinkNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 移至链表头部
     */
    private void moveToFirst(DoubleLinkNode node) {
        removeNode(node);
        addFirst(node);
    }

    /**
     * 从链表中尾部删除节点
     */
    private DoubleLinkNode removeTail() {
        DoubleLinkNode res = tail.prev;
        removeNode(res);
        return res;
    }

    /**
     * 删除节点
     */
    private void removeNode(DoubleLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
