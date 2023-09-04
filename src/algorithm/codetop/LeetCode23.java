package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.ListNode;

import java.util.PriorityQueue;

/**
 *@ClassName LeetCode23
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/9/4 9:32
 *@Version 1.0
 **/
public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeV1(lists, 0, lists.length - 1);
    }

    //分治归并，将k个链表配对并且将同一对中的链表进行合并。
    //时间复杂度：O（kn*logk）；空间复杂度：递归会使用到O（logk）代价的栈空间
    public ListNode mergeV1(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(mergeV1(lists, l, mid), mergeV1(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    //优先队列合并
    //这个方法和前两种方法的思路有所不同，我们需要维护当前每个链表没有被合并的元素的最前面一个，
    //k个链表就最多有k个满足这样条件的元素，每次在这些元素里面选取val属性最小的元素合并到答案中。
    //在选取最小元素的时候，我们可以用优先队列来优化这个过程。
    //时间复杂度O(kn*logk);空间复杂度：O(k);

    //小顶堆
    PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((node1, node2) -> node1.val - node2.val);

    public ListNode mergeKListsV2(ListNode[] lists) {
        for(ListNode node : lists){
            if(node !=null) queue.offer(node);
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()){
            ListNode poll = queue.poll();
            tail.next = poll;
            if(poll.next  != null){
                queue.offer(poll.next);
            }
            tail = tail.next;
        }
        return head.next;
    }
}
