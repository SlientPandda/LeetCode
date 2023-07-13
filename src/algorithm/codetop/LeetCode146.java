package algorithm.codetop;/**
 *
 */

import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName LeetCode146
 *@Description 实现lru 并且线程安全带超时时间
 *@Author wuhao51
 *@Date 2022/8/3 20:08
 *@Version 1.0
 **/
public class LeetCode146 {
    /** 手写双向链表
     *
     *
     */
    class LRUCache {
        class LinkedNode {
            int key;
            int value;
            LinkedNode prev;
            LinkedNode next;

            public LinkedNode() {

            }

            public LinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Map<Integer, LinkedNode> map = new HashMap<>();
        private int size;
        private int capacity;
        private LinkedNode head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.head = new LinkedNode();
            this.tail = new LinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            } else {
                LinkedNode node = map.get(key);
                moveToHead(node);
                return node.value;
            }

        }

        private void moveToHead(LinkedNode node) {
            deleteNode(node);
            addToHead(node);
        }

        private void deleteNode(LinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToHead(LinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        public void put(int key, int value) {
            //判断目前大小是否超过容量，如果超过容量，将尾节点移除，如果不超过，正常put
            LinkedNode node = map.get(key);
            if (node != null) {
                moveToHead(node);
                node.value = value;
            } else {
                node = new LinkedNode(key, value);
                addToHead(node);
                map.put(key, node);
                size++;
                if (size > capacity) {
                    map.remove(tail.prev.key);
                    deleteNode(tail.prev);
                    size--;
                }
            }
        }
    }



}
