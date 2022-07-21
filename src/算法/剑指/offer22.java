package 算法.剑指;/**
 *
 */

import 算法.DataStructure.ListNode;

/**
 *@ClassName offer22
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/7/21 11:19
 *@Version 1.0
 **/
public class offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        //单指针法 time O(N) space O(1)
//        int length = 0;
//        ListNode start = head;
//        while (head != null) {
//            length++;
//            head = head.next;
//        }
//        int i = length - k;
//        while (i > 0) {
//            start = start.next;
//            i--;
//        }
//        return start;
        //双指针法 一指针先走k个节点 二指针再走 等一指针到结尾 二指针位置在倒数第k个节点
        ListNode first = head, second = head;
        while (k > 0 && first != null) {
            first = first.next;
            k--;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;

    }
}
