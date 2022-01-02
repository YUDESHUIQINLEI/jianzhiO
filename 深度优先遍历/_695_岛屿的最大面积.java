package 深度优先遍历;

public class _695_岛屿的最大面积 {
    /**
     * 给你一个大小为 m x n 的二进制矩阵 grid 。
     *
     * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
     *
     * 岛屿的面积是岛上值为 1 的单元格的数目。
     *
     * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0
     *
     * 想法💡：找到一个岛屿记录他的面积 然后求最后的最大值
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int maxArea = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int col, int row){
        if(!ingrid(grid, col, row))
            return 0;
        if(grid[col][row] != 1)
            return 0;
        grid[col][row] = 2;
        return 1 + dfs(grid, col - 1, row) + dfs(grid, col + 1, row) +
        dfs(grid, col, row - 1) + dfs(grid, col, row + 1);
    }
    private boolean ingrid(int[][] grid, int col, int row){
        if((col >= 0 && col  < grid.length) && (row >= 0 && row < grid[0].length))
            return true;
        return false;
    }
}
