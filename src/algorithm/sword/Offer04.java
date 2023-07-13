package algorithm.sword;/**
 *
 */

/**
 *@ClassName offer04
 *@Description 二维数组中的查找
 *@Author wuhao51
 *@Date 2022/4/25 9:37
 *@Version 1.0
 **/
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 第一版 时间复杂度：O(m+n) 空间复杂度：O(1) 力扣用时 0ms 内存47.2MB
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = matrix[0].length - 1; j >= 0; j--) {
//                if (target > matrix[i][j]) break;
//                if (target == matrix[i][j]) return true;
//            }
//        }
//        return false;
        // 第二版 参数与第一版差不多 理论上稍快一点，搜索过程中到下一行不用回溯到末尾
        int i = 0;
        int j = matrix.length >0 ? matrix[0].length - 1 : -1;
        for (; i < matrix.length; i++) {
            for (; j >= 0; j--) {
                if (target > matrix[i][j]) break;
                if (target == matrix[i][j]) return true;
            }
        }
        return false;
    }
}
