package algorithm.codetop;/**
 *
 */

/**
 *@ClassName LeetCode240
 *@Description TODO
 *@Author wuhao51
 *@Date 2024/5/31 11:19
 *@Version 1.0
 **/
public class LeetCode240 {
    /**
     * 本题的关键是找到数字关系中不边的部分，比如本题，行从左到右升序，列从上到下升序，相交的部分为右上角。
     * 右上角的数字为大于行中左边所有的数字，小于列中下边所有的数字。
     * 所以我们可以先从右上角开始搜索。
     * 时间复杂度：O（M+N）
     * 空间复杂度：O（1）
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // 每行从左到右递增，每列从上到下递增，如果从右上角作为起始点开始搜索，目标数字小于当前点则应从当前列向左进一步，大于当前点则当前行向下进一步
        int x = 0, y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0 && matrix[x][y] != target) {
            if (target > matrix[x][y]) {
                x += 1;
            } else {
                y -= 1;
            }
        }
        return x < matrix.length && y >= 0 && matrix[x][y] == target;
    }
}
