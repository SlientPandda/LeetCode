package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.ListNode;

/**
 *@ClassName LeetCode92
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/8/1 15:57
 *@Version 1.0
 **/
public class LeetCode92 {
    ListNode next = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            next = head.next;
            return head;
        }
        ListNode res = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = next;
        return res;
    }

}
