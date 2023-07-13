package algorithm.interview;/**
 *
 */

import algorithm.datastructure.ListNode;

/**
 *@ClassName Interview0207
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/12/30 17:08
 *@Version 1.0
 **/
public class Interview0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0, sizeB = 0;
        ListNode tmpA = headA, tmpB = headB;
        while (tmpA != null) {
            sizeA++;
            tmpA = tmpA.next;
        }
        while (tmpB != null) {
            sizeB++;
            tmpB = tmpB.next;
        }
        int distance = Math.abs(sizeA - sizeB);

        return sizeA>sizeB ? getNode(headA, headB, distance) : getNode(headB, headA, distance);
    }

    private ListNode getNode(ListNode headLong, ListNode headShort, int distance) {
        for (int i = distance; i > 0; i--) {
            headLong = headLong.next;
        }

        while (true) {
            if (headLong == headShort) return headLong;
            headLong = headLong.next;
            headShort = headShort.next;
        }
    }
}
