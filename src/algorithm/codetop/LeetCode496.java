package algorithm.codetop;/**
 *
 */

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName LeetCode496
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/15 10:20
 *@Version 1.0
 * nums1 n nums2 m
 * 时间复杂度 O(m+n)
 * 空间复杂度 O(m)
 **/
public class LeetCode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            //栈底为更大元素
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) map.put(nums2[i], -1);
            else map.put(nums2[i], stack.peek());
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
