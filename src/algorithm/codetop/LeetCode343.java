package algorithm.codetop;/**
 *
 */

/**
 *@ClassName LeetCode343
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/9/5 11:02
 *@Version 1.0
 **/
public class LeetCode343 {
    public int integerBreak(int n) {
        //dp数组，n的和分解之后最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        //因为dp的每一位都是由前置所有位取最大值推导出来的，所以需要两个循环
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

}
