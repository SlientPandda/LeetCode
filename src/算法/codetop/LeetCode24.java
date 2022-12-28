package 算法.codetop;/**
 *
 */

import 算法.DataStructure.ListNode;

/**
 *@ClassName LeetCode24
 *@Description
 *@Author wuhao51
 *@Date 2022/12/28 9:12
 *@Version 1.0
 **/
public class LeetCode24 {
    public static ListNode swapPairs(ListNode head) {
//      虚拟头节点
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode pre = dummyNode;

//      如果下面两个节点都不为空，则可以进行交换
        while (pre.next != null && pre.next.next != null) {
//            暂存第三个节点和第一个节点
            ListNode tmp = head.next.next;

//            交换节点
            pre.next = head.next;
            head.next.next = head;
            head.next = tmp;

            pre = head;
            head = head.next;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode dummyNode = head;
        for (int i = 1; i < 5; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        swapPairs(dummyNode.next);
    }
}
