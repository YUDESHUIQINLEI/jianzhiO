package 深度优先遍历;

public class _463_岛屿的周长 {
    /**
     * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
     * 计算岛屿的周长 假设只有一个岛屿
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 1)
                    sum = dfs(grid, i, j);
            }
        }
        return sum;
    }
    private int dfs(int[][] grid, int col, int raw){
        if(! ingrid(grid, col, raw)) //代表的是界限
            return 1;
        if(grid[col][raw] == 0)  //代表一边的周长
            return 1;
        if(grid[col][raw] == 2)
            return 0;
        grid[col][raw] = 2;
        return dfs(grid, col - 1, raw) + dfs(grid, col + 1, raw) +
                dfs(grid, col,raw - 1) + dfs(grid, col, raw + 1);
    }
    private boolean ingrid(int[][] grid, int col, int row){
        if((col >= 0 && col  < grid.length) && (row >= 0 && row < grid[0].length))
            return true;
        return false;
    }
}
