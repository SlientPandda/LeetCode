package algorithm.codetop;/**
 *
 */

/**
 *@ClassName LeetCode200
 *@Description TODO
 *@Author wuhao51
 *@Date 2024/4/9 13:55
 *@Version 1.0
 **/
public class LeetCode200 {
    private int res = 0;

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果访问的是陆地，直接沉没相连的陆地
                if (grid[i][j] == '1') {
                    dfsIsland(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfsIsland(char[][] grid, int i, int j) {
        // 越界或者是海洋直接返回
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        // 已经访问过的陆地沉没为海洋，直接标为0
        grid[i][j] = '0';
        // 沉没相连的陆地（如果有的话）
        dfsIsland(grid, i + 1, j);
        dfsIsland(grid, i - 1, j);
        dfsIsland(grid, i, j + 1);
        dfsIsland(grid, i, j - 1);
    }
}
