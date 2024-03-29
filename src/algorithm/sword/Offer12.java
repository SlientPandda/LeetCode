package algorithm.sword;/**
 *
 */

/**
 *@ClassName offer12
 *@Description 算法.剑指 Offer 12. 矩阵中的路径
 *@Author wuhao51
 *@Date 2022/5/17 16:34
 *@Version 1.0
 **/
public class Offer12 {
    //time O(3^k MN) space  函数调用累计使用的栈空间 O(K)
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //终止条件：上下左右碰到边界，或者已访问，或者与当前字符不相等
        if (i > (board.length - 1) || j > (board[0].length - 1) || i < 0 || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i, j - 1, k + 1) || dfs(board, word, i, j + 1, k + 1);
        board[i][j] = word[k];
        return res;
    }
}
