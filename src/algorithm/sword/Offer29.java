package algorithm.sword;/**
 *
 */

/**
 *@ClassName offer29
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/7/22 20:10
 *@Version 1.0
 **/
public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[matrix[0].length * matrix.length];
        while (true) {
            for (int i = 0; i <= r; i++) res[x++] = matrix[b][i];
            if (++t > b) break;
        }
        return new int[1];
    }
}
