package 算法.codetop;/**
 *
 */

import java.util.Arrays;

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
    public static int findMaxForm(String[] strs, int m, int n) {
        //相当于两种种类限制条件的背包
        //dp[i][j]表示i个0和j个1时的最大子集
        int[][] dp = new int[m + 1][n + 1];
        int oneNum, zeroNum;
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            //倒序遍历
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[m][n];
    }

    public static void main(String[] args){
        System.out.println(findMaxForm(new String[]{"10","0001","111001","1","0"}, 3 ,3));
    }


}
