package algorithm.linkedlist;/**
 *
 */

import algorithm.datastructure.ListNode;

/**
 *@ClassName LeetCode83
 *@Description 删除排序链表中的重复元素
 *@Author wuhao51
 *@Date 2024/8/2 17:02
 *@Version 1.0
 **/
public class LeetCode83 {
    public ListNode deleteDuplicates(ListNode head) {
        // 如果链表只有头节点 直接返回
        if (head == null || head.next == null) return head;
        // 当前节点
        ListNode tmpNode = head;
        // 遍历当前链表，直至为空
        while (tmpNode != null) {
            ListNode nextNode  = tmpNode.next;
            // 如果当前节点的下一节点不为空 并且当前节点值和下一节点值相同 跳过下一节点
             while (nextNode != null && tmpNode.val == nextNode.val){
                 tmpNode.next = nextNode.next;
                 nextNode = nextNode.next;
             }
            // 当前节点移动到下一节点
            tmpNode = tmpNode.next;
        }
        // 返回头节点
        return head;
    }
}
