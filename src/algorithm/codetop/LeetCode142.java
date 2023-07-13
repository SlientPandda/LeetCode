package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.ListNode;

/**
 *@ClassName LeetCode142
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/1/5 19:33
 *@Version 1.0
 **/
public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
//        快慢指针法判断是否有环
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode tmp = fast;
                while (tmp != head) {
                    tmp = tmp.next;
                    head = head.next;
                }
                return tmp;
            }
        }
        return null;
    }
}
