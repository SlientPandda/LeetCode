package algorithm.sword;/**
 *
 */

/**
 *@ClassName offer14_1
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/6/23 15:39
 *@Version 1.0
 **/
public class Offer14_1 {
    public int cuttingRope(int n) {
        /**
         dp五部曲:
         1.状态定义:dp[i]为长度为i的绳子剪成m段最大乘积为dp[i]
         2.状态转移:dp[i]有两种途径可以转移得到
         2.1 前后两段都单成一段，乘积为（i-j）*j
         2.2 前段取最大乘积dp[i-j]，后端j乘以前端，dp[i-j]*j
         两种情况中取大的值作为dp[i]的值,同时应该遍历所有j,j∈[1,i-1],取最大值
         3.初始化:初始化dp[2]=1即可
         4.遍历顺序:正序遍历
         5.返回坐标:返回dp[n]
         time O(N^2) space O(N)
         */
//        int[] dp = new int[n + 1];
//        dp[2] = 1;
//        for (int i = 3; i < n + 1; i++) {
//            for (int j = 1; j <=i/2 + 1; j++) {
//                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
//            }
//        }
//        return dp[n];
        /**
         * 数学推导方法
         * 1、用算术几何均值不等式，可以得出绳子均分之后乘积最大，再通过求导的方式，可以得出极大值点为e，则当绳子均分长度为3时，乘积取到最大值。
         * 2、当n<=3时，按照规则应不切分，但由于题目要求必须剪成 m>1 段，因此必须剪出一段长度为 1 的绳子，即返回 n - 1。
         * 3、当 n>3 时，求 n 除以 3 的 整数部分 a 和 余数部分 b （即 n = 3a + b），并分为以下三种情况：
         * 1）当 b = 0 时，直接返回 3^a
         * 2）当b=1时，要将一个3+1转换为2+2因此返回 3^{a-1} * 4
         * 3）当 b = 2时，返回 3^a *2
         *
         * time O(1) space O(1)
         **/
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }
}
