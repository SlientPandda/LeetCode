package algorithm.sword;/**
 *
 */

import algorithm.datastructure.ListNode;

/**
 *@ClassName offer18
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/7/8 14:40
 *@Version 1.0
 **/
public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        //timeO(N) space O(1)
        if (head.val == val || head == null) return head.next;
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            if (val == cur.val) {
                pre.next = cur.next;
                return head;
            }
            cur = cur.next;
            pre = pre.next;
        }
        return head;
    }
}
