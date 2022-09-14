package 算法.codetop;/**
 *
 */

/**
 *@ClassName BackPackTemplate
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/9/13 13:57
 *@Version 1.0
 **/
public class BackPackTemplate {
    /**
     * 0-1背包问题基础模版 二维dp数组
     * @param n 可供选择的物品个数
     * @param w 背包当前容量
     * @param weight 物品对应的容量数组
     * @param value 物品对应的价值数组
     */
    public static int backPackV1(int n, int w, int[] weight, int[] value) {
        //1、明确dp数组：从（0，i）的物品中选择，放入容量为j的背包中，价值总和最大是多少
        int[][] dp = new int[n][w + 1];
        //2、确定递推公式：
        //
        //
        // dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
        //3、初始化dp数组：dp是二维数组，根据dp定义需初始化dp[i][0]、dp[0][j]的边界情况
        //当背包不选择物品时，即对应价值总和最大为0，dp数组初始化为0
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        //当背包不满足第一个物品的重量时，即不放入背包，dp数组对应初始化为0
        for (int j = 0; j < weight[0]; j++) {
            dp[0][j] = 0;
        }
        //由于Java int数组元素初始化为0，故以上两步可以省略
        //当背包容量满足第一个物品的重量时，即放入背包，dp数组更新为value[0]
        for (int j = weight[0]; j <= w; j++) {
            dp[0][j] = value[0];
        }
        //4、确定数组遍历顺序
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= w; j++) {
                //需要判断下当前物品的容量是否比背包容量大，如果比背包容量大的话，需要避免放入，防止递推时造成数组越界
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[n - 1][w];
    }

    /**
     0-1背包问题基础模版 滚动dp数组
     * @param n 可供选择的物品个数
     * @param w 背包当前容量
     * @param weight 物品对应的容量数组
     * @param value 物品对应的价值数组
     */
    public static int backPackV2(int n, int w, int[] weight, int[] value) {
        //1、明确dp数组的定义：一维滚动数组，dp[j]表示：容量为j的背包，所背的物品价值最大为dp[j]
        int[] dp = new int[w + 1];
        //2、明确递推公式：dp[j]=Math.max(dp[j], dp[j-weight[i]]+value[i]])
        //3、数组初始化：都初始化为0
        //4、明确遍历顺序：物品数在外正序，背包容量在内倒序，避免物品重复放入，并且本质上还是二维dp数组右下角元素依赖左上角的方法。
        for (int i = 0; i < n; i++) {
            for (int j = w; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[w];
    }

    public static void main(String[] args) {
        System.out.println(backPackV2(3, 4, new int[]{1, 3, 4}, new int[]{15, 20, 30}));
    }
}
