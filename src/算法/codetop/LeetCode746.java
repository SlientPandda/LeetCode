package 算法.codetop;/**
 *
 */

/**
 *@ClassName LeetCode746
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/8/29 20:22
 *@Version 1.0
 **/
public class LeetCode746 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        //走到当前台阶最少花费
        int dp0 = 0, dp1 = 0;
        for (int i = 2; i < len + 1; i++) {
            int dpi = Math.min(dp0 + cost[i - 2], dp1 + cost[i - 1]);
            dp0 = dp1;
            dp1 = dpi;
        }
        return dp1;
    }
}
