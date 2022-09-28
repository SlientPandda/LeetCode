package 算法.codetop;/**
 *
 */

import java.util.Arrays;

/**
 *@ClassName LeetCode494
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/9/21 20:56
 *@Version 1.0
 **/
public class LeetCode494 {
    public static int findTargetSumWays(int[] nums, int target) {
        //问题转化为求满足left- right = target的left容量的背包容纳数字总数大小
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //目标值的绝对值比总和大 或者 target+sum为奇数（left-right=target） 则都无解
        if (Math.abs(target) > sum) return 0;
        if (((target + sum) & 1) == 1) return 0;
        int left = (target + sum) / 2;
        //1、明确dp数组定义，填满容量为j这么大容积的包，有dp[j]种方法
        int[] dp = new int[left + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = left; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[left];
    }

    public static void main(String[] args){
        int[] a = new int[]{1,1,1,1,1};
        findTargetSumWays(a, 3);
    }

}
