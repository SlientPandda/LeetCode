package 算法.codetop;/**
 *
 */

/**
 *@ClassName LeetCode209
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/10/17 9:07
 *@Version 1.0
 **/
public class LeetCode209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int size = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                size = Math.min(size, j - i + 1);
                sum -= nums[i++];
            }
        }
        return size == Integer.MAX_VALUE ? 0 : size;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
