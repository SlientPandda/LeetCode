package 算法.剑指;/**
 *
 */

import java.util.LinkedList;

/**
 *@ClassName offer06
 *@Description 从尾到头打印链表
 *@Author wuhao51
 *@Date 2022/4/26 16:51
 *@Version 1.0
 **/
public class offer06 {
//    1、递归法 时间复杂度O(N) 空间复杂度O(N)
//    public List<Integer> res = new ArrayList<>();
//    public int[] reversePrint(ListNode head) {
//        recur(head);
//        int[] resInt = new int[res.size()];
//        for (int i = 0; i < res.size(); i++) {
//            resInt[i] = res.get(i);
//        }
//        return resInt;
//    }
//
//    public void recur(ListNode head) {
//        if (head == null) return;
//        recur(head.next);
//        res.add(head.val);
//    }

//    2、辅助栈法 时间复杂度O(N) 空间复杂度O(N)
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
        return res;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
