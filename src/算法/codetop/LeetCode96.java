package 算法.codetop;/**
 *
 */

/**
 *@ClassName LeetCode96
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/9/6 10:39
 *@Version 1.0
 **/
public class LeetCode96 {
    public int numTrees(int n) {
        //time O(N^2)
        //i个不同元素组成的不同结构的二叉搜索树的个数
        int[] dp = new int[n + 1];
        //空树也是树
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

}
