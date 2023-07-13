package algorithm.sword;/**
 *
 */

/**
 *@ClassName offer13
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/6/22 15:06
 *@Version 1.0
 **/
public class Offer13 {
    private int row;
    private int col;
    private boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        row = m - 1;
        col = n - 1;
        visited = new boolean[m][n];
        return dfs(0, 0, k);
    }

    //深度优先遍历
    public int dfs(int i, int j, int k) {
        //超过边界或数位和超过k或已访问过，返回0，代表不能走
        if (i > row || i < 0 || j > col || j < 0 || sum(i) + sum(j) > k || visited[i][j] == true) return 0;
        //符合条件将标志数组设为true代表走过，并将总和加一
        visited[i][j] = true;
        //由于机器人往下或者右走就可以走到所有连通性的可达解
        int sum = 1 + dfs(i + 1, j, k) + dfs(i, j + 1, k);
        return sum;
    }

    //计算数位和
    public int sum(int a) {
        int sum = 0;
        while (a > 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }
//    int m, n, k;
//    boolean[][] visited;
//    public int movingCount(int m, int n, int k) {
//        this.m = m; this.n = n; this.k = k;
//        this.visited = new boolean[m][n];
//        return dfs(0, 0, 0, 0);
//    }
//    public int dfs(int i, int j, int si, int sj) {
//        if(i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
//        visited[i][j] = true;
//        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
//    }

}
