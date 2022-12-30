package 算法.codetop;/**
 *
 */

import 算法.DataStructure.ListNode;

/**
 *@ClassName LeetCode19
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/12/28 10:35
 *@Version 1.0
 **/
public class LeetCode19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        使用双指针法定位需要删除的元素
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        //pre代表指向要删除的前一个节点，初始指向虚拟头节点，cur指向当前正在遍历的节点，初始指向实际头节点
        //cur需要领先pre n个节点的距离（与末尾判断的位置有关，此处是判断next是否为空）
        ListNode pre = dummyNode, cur = head;
        int i = 1;
//        当cur到达第n+1个时，pre开始出发
        while (cur.next != null) {
            cur = cur.next;
            i++;
            if (i > n) {
                pre = pre.next;
            }
        }
        pre.next = pre.next.next;

        return dummyNode.next;
    }

    public static ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;

        //只要快慢指针相差 n 个结点即可
        for (int i = 0; i < n  ; i++){
            fastIndex = fastIndex.next;
        }

        while (fastIndex.next != null){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        //此时 slowIndex 的位置就是待删除元素的前一个位置。
        //具体情况可自己画一个链表长度为 3 的图来模拟代码来理解
        slowIndex.next = slowIndex.next.next;
        return dummyNode.next;

    }

    public static void main(String[] args) {
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        for (int i = 1; i <= 1; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        System.out.println(removeNthFromEnd(dummyNode.next, 1));
    }
}
