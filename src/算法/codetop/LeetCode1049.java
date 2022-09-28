package 算法.codetop;/**
 *
 */

import java.util.Arrays;
import java.util.List;

/**
 *@ClassName LeetCode1049
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/9/14 20:11
 *@Version 1.0
 **/
public class LeetCode1049 {
    public int lastStoneWeightII(int[] stones) {
        //time O(m*n) n为石头块数 m是石头总重量的一半
        //1、确定dp数组含义：dp[j]表示容量为j的背包，最多可以容纳价值为dp[j]的石头
        //初始化 dp数组 数组大小为 最大重量 3000 的一半 1500
        //递推公式 dp[j] = Math.max(dp[j], dp[j-stones[j]] + stons[j])
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return (sum - dp[target]) - dp[target];
    }


}
