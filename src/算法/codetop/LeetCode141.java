package 算法.codetop;/**
 *
 */

import 算法.DataStructure.ListNode;

/**
 *@ClassName LeetCode141
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/1/6 16:54
 *@Version 1.0
 **/
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
