package 算法.codetop;/**
 *
 */

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 *@ClassName LeetCode239
 *@Description
 *@Author wuhao51
 *@Date 2023/2/2 11:59
 *@Version 1.0
 *
 * 时间复杂度 O(N)
 * 空间复杂度 O(K)单调队列长度
 **/
public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        //单调队列存储当前滑动窗口内可能最大的值对应的nums数组下标，从头到尾由大到小
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //如果队列非空并且头结点离开滑动窗口，则弹出头节点
            while (!deque.isEmpty() && deque.getFirst() < i - k + 1) {
                deque.removeFirst();
            }
            //如果队列非空并且当前元素大于尾节点，则循环弹出尾节点
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            //从滑动窗口初始右节点循环到数组最尾节点
            if (i >= k - 1) {
                res[j++] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}
