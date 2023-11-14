package algorithm.codetop;/**
 *
 */

/**
 *@ClassName LeetCode48
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/11/14 10:39
 *@Version 1.0
 **/
public class LeetCode48 {
    public void rotate(int[][] matrix) {
        //找规律，对于矩阵中第 i 行的第 j 个元素，在旋转后，它出现在倒数第 i 列的第 j 个位置。
        //旋转时，由于要旋转四次，所以将数组分为四个部分，枚举其中一个部分即可。
        // 当 n 为奇数时，由于中心的位置经过旋转后位置不变,矩阵正中央的点无需旋转。
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
