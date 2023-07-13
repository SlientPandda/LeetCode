package algorithm.sword;/**
 *
 */

import algorithm.datastructure.ListNode;

/**
 *@ClassName offer25
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/7/21 14:41
 *@Version 1.0
 **/
public class Offer25 {
    //time O(N) space O(1)
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1), start = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        res.next = l1 == null ? l2 : l1;
        return start.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1), l2 = new ListNode(1);
        l1.next = new ListNode(4);
        l2.next = new ListNode(4);
        mergeTwoLists(l1, l2);
    }


}
