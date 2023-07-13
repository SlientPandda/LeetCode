package algorithm.codetop;/**
 *
 */

/**
 *@ClassName LeetCode977
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/10/13 14:36
 *@Version 1.0
 **/
public class LeetCode977 {
    public int[] sortedSquares(int[] nums) {
        //双指针法 时间O(N) 空间O(N)
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1, index = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left] * nums[left];
                left++;
            } else {
                result[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}
