package 算法.codetop;/**
 *
 */

/**
 *@ClassName LeetCode53
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/8/24 19:43
 *@Version 1.0
 **/
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        //动态规划 time O(N) space O(N)
        int len = nums.length;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        int maxSub = dp[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            if (maxSub < dp[i]) {
                maxSub = dp[i];
            }
        }
        return maxSub;
    }
}
