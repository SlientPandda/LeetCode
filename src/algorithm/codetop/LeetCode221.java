package algorithm.codetop;/**
 *
 */

/**
 *@ClassName LeetCode221
 *@Description TODO
 *@Author wuhao51
 *@Date 2024/4/16 9:32
 *@Version 1.0
 **/
public class LeetCode221 {
    //时间复杂度：O(mn min(m,n)^2)，其中 m 和 n 是矩阵的行数和列数。
    //需要遍历整个矩阵寻找每个1，遍历矩阵的时间复杂度是 O(mn)。
    //对于每个可能的正方形，其边长不超过 m 和 n 中的最小值，需要遍历该正方形中的每个元素判断是不是只包含 1，遍历正方形时间复杂度是 O(min(m,n)^2)
    //总时间复杂度是 O(mn min(m,n)^2)
    //空间复杂度：O(1)。额外使用的空间复杂度为常数
    // 暴力法
    public int maximalSquareForceV1(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // 遍历整个矩阵，寻找可能为结果的正方形的左上角的1.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    maxSide = Math.max(maxSide, 1);
                    //找到左上角的1后，开始确定以此节点为左上角的正方形最大面积
                    int currentMaxSide = Math.min(matrix.length - i, matrix[0].length - j);
                    for (int k = 1; k < currentMaxSide; k++) {
                        boolean flag = true;
                        // 先确定右下角是否是1，如果不是直接返回
                        if (matrix[i + k][j + k] == '0') break;
                        // 再确定新增的最边上的一行和一列
                        for (int l = 0; l < k; l++) {
                            if (matrix[i + l][j + k] == '0' || matrix[i + k][j + l] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            // 注意k要+1
                            maxSide = Math.max(k + 1, maxSide);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        // 注意返回的是正方形面积
        return maxSide * maxSide;
    }

    /**
     * 动态规划法
     * 时间复杂度O(mn)
     * 空间复杂度O(mn)
     * @param matrix
     * @return
     */
    public int maximalSquareDP(char[][] matrix) {
        // 1、确定dp数组含义
        // 2、确定递推公式
        // 3、dp数组初始化
        // 4、确定遍历顺序
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        //我们用dp（i，j） 表示以 (i,j)为右下角，且只包含 1 的正方形的边长最大值。
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 确定递推公式
                        // 若某格子值为 1，则以此为右下角的正方形的、最大边长为：上面的正方形、左面的正方形或左上的正方形中，最小的那个，再加上此格。
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    // 注意记得比较得出最大边长
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }
}
