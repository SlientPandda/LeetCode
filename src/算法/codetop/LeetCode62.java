package 算法.codetop;/**
 *
 */

/**
 *@ClassName LeetCode63
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/9/1 17:22
 *@Version 1.0
 **/
public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        //dp数组定义，从0，0出发到m,n点有几条不同的路径
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
