package 算法.codetop;/**
 *
 */

import 算法.DataStructure.ListNode;

/**
 *@ClassName LeetCode25
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/8/10 19:50
 *@Version 1.0
 **/
public class LeetCode25 {
    ListNode next = null;

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        int i = 1;
        while (i <= k) {
            //如果最后一组不足k个也需要反转 则改成break
            if (tail == null) return head;
            tail = tail.next;
            i++;
        }
        ListNode res = reverseK(head, i - 1);
        if (tail != null) {
            head.next = reverseKGroup(tail, k);
        }
        return res;
    }

    public ListNode reverseK(ListNode head, int n) {
        if (n == 1) {
            next = head.next;
            return head;
        }
        ListNode res = reverseK(head.next, n - 1);
        head.next.next = head;
        head.next = next;
        return res;
    }

}
