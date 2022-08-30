package 算法.codetop;/**
 *
 */

import java.util.Arrays;

/**
 *@ClassName LeetCode300
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/8/25 19:35
 *@Version 1.0
 **/
public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
