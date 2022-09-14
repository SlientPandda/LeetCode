package 算法.codetop;/**
 *
 */

import java.util.WeakHashMap;

/**
 *@ClassName LeetCode416
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/9/6 20:27
 *@Version 1.0
 **/
public class LeetCode416 {
    public boolean canPartition(int[] nums) {
        //如果nums的和为奇数，则不能分割成两个相等子集
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        //1、确定dp数组定义,为容量为j的背包最大价值
        int badge = sum / 2;
        int[] dp = new int[badge + 1];
        //2、递推公式：0-1背包公式
        //3、初始化：由于给出数组元素都为正整数，则默认初始化为0即可
        //4、确定遍历顺序：01背包一维dp数组外层物品，内层背包容量，且内层必须倒序遍历
        for (int i = 0; i < nums.length; i++) {
            for (int j = badge; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[badge] == badge;
    }

}
