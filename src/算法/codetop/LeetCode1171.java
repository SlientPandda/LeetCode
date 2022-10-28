package 算法.codetop;/**
 *
 */

import 算法.DataStructure.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName LeetCode1171
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/10/25 10:44
 *@Version 1.0
 **/
public class LeetCode1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        //两次遍历 时间O(N) 控件O(N)
        //创建一个假的头节点，next指向头部，
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //创建一个map存放当前和与对应节点地址的键值对
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        //遍历链表，同样地址覆盖更新
        for (ListNode tmp = dummy; tmp != null; tmp = tmp.next) {
            sum += tmp.val;
            map.put(sum, tmp);
        }
        //再次遍历链表，如果找到同样总和值的节点，将next更新为这个节点
        sum = 0;
        for (ListNode tmp = dummy; tmp != null; tmp = tmp.next) {
            sum += tmp.val;
            tmp.next = map.get(sum).next;
        }

        return dummy.next;
    }

}
