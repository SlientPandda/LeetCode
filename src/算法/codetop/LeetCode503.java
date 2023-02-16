package 算法.codetop;/**
 *
 */

import java.util.ArrayDeque;

/**
 *@ClassName LeetCode503
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/15 11:46
 *@Version 1.0
 * 时间复杂度 O(N)
 * 空间复杂度 O(N)
 **/
public class LeetCode503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
                stack.pop();
            }
            if (i < nums.length) res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % nums.length]);
        }
        return res;
    }
}
