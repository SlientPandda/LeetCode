package 算法.codetop;/**
 *
 */

import 算法.DataStructure.ListNode;

/**
 *@ClassName LeetCode203
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/11/30 9:29
 *@Version 1.0
 **/
public class LeetCode203 {
    public ListNode removeElements(ListNode head, int val) {
        //时间复杂度： 空间复杂度：
        //添加虚拟节点进行统一操作
        ListNode dummyNode = new ListNode(-1, head);
        ListNode pre = dummyNode;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummyNode.next;
    }
}
