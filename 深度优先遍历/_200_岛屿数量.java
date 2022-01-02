package 深度优先遍历;

public class _200_岛屿数量 {
    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 想法💡：发现有1之后，就一直向下遍历，遍历到非1的时候截止
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int num = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == '1'){
                    ++ num;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }
    private void dfs(char[][] grid, int col, int row){
        if(! ingrid(grid, col, row))
            return;
        if(grid[col][row] != 1)
            return;
        grid[col][row] = 2;
        dfs(grid, col - 1, row);
        dfs(grid, col + 1, row);
        dfs(grid, col, row - 1);
        dfs(grid, col, row + 1);
    }
    private boolean ingrid(char[][] grid, int col, int row){
        if((col >= 0 && col  < grid.length) && (row >= 0 && row < grid[0].length))
            return true;
        return false;
    }
}
