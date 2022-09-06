package 算法.codetop;/**
 *
 */

/**
 *@ClassName LeetCode503
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/8/29 20:05
 *@Version 1.0
 **/
public class LeetCode509 {
    public int fib(int n) {
        if (n <= 2) return n;
        int sum = 0;
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return sum;
    }

}
