package algorithm.codetop;/**
 *
 */

/**
 *@ClassName LeetCode279
 *@Description TODO
 *@Author wuhao51
 *@Date 2024/6/3 11:06
 *@Version 1.0
 **/
public class LeetCode279 {
    /**
     * 动态规划算法
     * 时间复杂度：O（N√N）
     * 空间复杂度：O（N）
     * @param n
     * @return
     */
    public int numSquares(int n) {
        // 完全平方数是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，①、④、9 和 16 都是完全平方数，而 3 和 11 不是。
        // 求和为N的完全平方数的最少数量，其实只需要关注1~根号N的区间即可，因为如果本身是完全平方数，则结果为1
        // 明确dp数组含义 dp[i]为 组成和为i的完全平方数的最少数量
        // 确定dp转移公式：dp[i] = 1 + min(dp[i-j^2])(j:1-根号i)
        // 确定dp遍历顺序：从0 - n
        // 确定dp数组初始值：dp[0] = 0
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    /**
     * 数学定理算法：四平方和，四平方和定理证明了任意一个正整数都可以被表示为至多四个正整数的平方和。这给出了本题的答案的上界。
     * 时间复杂度：O（√N）
     * 空间复杂度：O(1)。我们只需要常数的空间保存若干变量。
     * @param n
     * @return
     */
    public int mathNumSquares(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    // 判断是否为完全平方数
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // 判断是否能表示为 4^k*(8m+7)
    public boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }
}
