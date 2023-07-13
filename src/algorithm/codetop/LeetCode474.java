package algorithm.codetop;/**
 *
 */

/**
 *@ClassName LeetCode474
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/9/22 10:58
 *@Version 1.0
 **/
public class LeetCode474 {
    /**
     *
     * @param strs 二进制字符串数组
     * @param m 子集中0的最多个数
     * @param n 子集中1的最多个数
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        //时间复杂度 O(strs.length * m *n) 空间复杂度 O(m * n)
        //相当于两种种类限制条件的背包
        //dp[i][j]表示i个0和j个1时的最大子集
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroNum = 0, oneNum = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
