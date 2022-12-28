package 算法.codetop;/**
 *
 */

import 算法.DataStructure.ListNode;

import java.nio.channels.ClosedSelectorException;
import java.util.List;

/**
 *@ClassName LeetCode707
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/12/1 19:54
 *@Version 1.0
 **/
public class LeetCode707 {

    static class MyLinkedList {

        ListNode dummyHead;

        public MyLinkedList() {
            dummyHead = new ListNode();
        }

        public int get(int index) {
            if (index < 0) {
                return -1;
            }
            int i = 0;
            ListNode cur = dummyHead.next;
            while (cur != null && i <= index) {
                if (i == index) return cur.val;
                cur = cur.next;
                i++;
            }
            return -1;
        }

        public void addAtHead(int val) {
            ListNode toAddNode = new ListNode(val);
            toAddNode.next = dummyHead.next;
            dummyHead.next = toAddNode;
        }

        public void addAtTail(int val) {
            ListNode toAddNode = new ListNode(val);
            ListNode cur = dummyHead;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = toAddNode;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0) {
                addAtTail(val);
            }
            ListNode toAddNode = new ListNode(val);
            ListNode cur = dummyHead;
            ListNode pre = dummyHead;
            int i = -1;
            while (cur != null && i <= index) {
                if (i == index) {
                    toAddNode.next = cur;
                    pre.next = toAddNode;
                    return;
                }
                pre = cur;
                cur = cur.next;
                i++;
            }
            if (cur == null && i == index) {
                pre.next = toAddNode;
            }
        }

        public void deleteAtIndex(int index) {
            if (index < 0) {
                return;
            }
            ListNode cur = dummyHead;
            ListNode pre = dummyHead;
            int i = -1;
            while (cur != null && i <= index) {
                if (i == index) {
                    pre.next = cur.next;
                    return;
                }
                pre = cur;
                cur = cur.next;
                i++;
            }
        }

        public void print() {
            StringBuilder stringBuilder = new StringBuilder("");
            ListNode cur = dummyHead.next;
            while (cur != null) {
                stringBuilder.append(cur.val + "->");
                cur = cur.next;
            }
            System.out.println(stringBuilder.toString());
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.print();
        myLinkedList.addAtTail(3);
        myLinkedList.print();
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.print();
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        myLinkedList.print();
        System.out.println(myLinkedList.get(1));
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 */

}
