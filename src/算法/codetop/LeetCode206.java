package 算法.codetop;/**
 *
 */

import 算法.DataStructure.ListNode;

/**
 *@ClassName LeetCode206
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/8/1 14:31
 *@Version 1.0
 **/
public class LeetCode206 {
    //递归和迭代两种方法 递归：自上而下，重复调用自身方法 迭代：自下而上，会有个循环赋初始值的过程
    public ListNode reverseList(ListNode head) {
        return recur(null, head);
    }

    //time O(N) space O(N)
    public ListNode recur(ListNode pre, ListNode cur) {
        if (cur == null) return pre;
        ListNode res = recur(cur, cur.next);
        cur.next = pre;
        return res;
    }

    //time O(N) space O(1)
    public ListNode repeat(ListNode pre, ListNode cur) {
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

}
