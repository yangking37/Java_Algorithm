package com.sky;

import java.util.HashMap;

public class L146 {
    class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;

        ListNode() {
        }

        ListNode(int key) {
            this.key = key;
        }

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class LRUCache {
        int capacity;
        ListNode head, tail;
        HashMap<Integer, ListNode> map;

        public LRUCache(int capacity) {
            map = new HashMap<Integer, ListNode>();
            this.capacity = capacity;
            head = new ListNode();
            tail = new ListNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                moveToHead(map.get(key));
                return map.get(key).value;
            }// 节点存在
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) { // 节点存在，修改节点，并修改链表
                moveToHead(map.get(key));
                map.get(key).value = value;
            } else {
                ListNode newNode = new ListNode(key, value); // 添加节点
                addtoHead(newNode);
                map.put(key, newNode);
                if (map.size() > capacity) { // 如果过多，则减去一个
                    map.remove(tail.prev.key);
                    removeNode(tail.prev);
                }
            }
        }

        public void removeNode(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void addtoHead(ListNode node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        public void moveToHead(ListNode node) {
            removeNode(node);
            addtoHead(node);
        }
    }
}
