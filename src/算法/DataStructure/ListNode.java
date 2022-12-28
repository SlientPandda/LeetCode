package 算法.DataStructure;/**
 *
 */

/**
 *@ClassName ListNode
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/7/8 14:39
 *@Version 1.0
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(){

    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode node) {
        val = x;
        next = node;
    }
}
