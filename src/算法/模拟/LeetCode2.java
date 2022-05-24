package 算法.模拟;/**
 *
 */

/**
 *@ClassName AddTwoNumbers
 *@Description 2. 两数相加
 *@Author wuhao51
 *@Date 2022/3/10 10:55
 *@Version 1.0
 **/
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0); //头节点
        ListNode tmp = head; //哨兵
        int t = 0;
        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            t = a + b + t;
            tmp.next = new ListNode(t % 10);
            t /= 10;
            tmp = tmp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (t > 0) {
            tmp.next = new ListNode(t);
        }
        return head.next;
    }

    public static void main(String[] args) {
        int t = 11;
        System.out.println(t /= 10);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}



