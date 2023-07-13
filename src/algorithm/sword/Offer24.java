package algorithm.sword;/**
 *
 */

import algorithm.datastructure.ListNode;

/**
 *@ClassName offer24
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/7/21 11:42
 *@Version 1.0
 **/
public class Offer24 {

    public ListNode reverseList(ListNode head) {
        return recur(head, null);    // 调用递归并返回
    }

    //递归法 time O(N) space O(N)
    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre; // 终止条件
        ListNode res = recur(cur.next, cur);  // 递归后继节点
        cur.next = pre;              // 修改节点引用指向
        return res;                  // 返回反转链表的头节点
    }

    //迭代法 time O(N) space O(1)
    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;  // 首节点的next需要置空，否则会成环，故cur需要从头节点开始
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

}
