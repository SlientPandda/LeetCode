package 剑指;/**
 *
 */

import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName offer06
 *@Description 从尾到头打印链表
 *@Author wuhao51
 *@Date 2022/4/26 16:51
 *@Version 1.0
 **/
public class offer06 {
    public static List<Integer> res = new ArrayList<>();

    public static int[] reversePrint(ListNode head) {

    }

    public static void recur(ListNode head) {
        if (head == null) return;
        recur(head.next);
        res.add(head.val);
    }


    public static void main(String[] args) {
        reversePrint(null);
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
