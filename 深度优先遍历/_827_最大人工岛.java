package 深度优先遍历;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _827_最大人工岛 {
    /**
     * 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
     *
     * 返回执行此操作后，grid 中最大的岛屿面积是多少？
     *
     * 岛屿 由一组上、下、左、右四个方向相连的1 形成。
     *
     * 想法💡：算出每个岛屿的面积 再遍历一遍找0 若0周围有岛屿，进行面积的相加
     * 为了不一个岛屿重复相加，利用flag进行标志
     * @param grid
     * @return
     */
    public int largestIsland(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int flag = 2;
        int maxArea = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j, flag);
                    map.put(flag, area);
                    maxArea = Math.max(maxArea, area);
                }
                ++ flag;
            }
        }
        for(int i = 0; i < grid.length; i ++ ){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 0){
                    maxArea = Math.max(maxArea, helper(grid, i, j, map));
                }
            }
        }
        return maxArea;
    }
    private int helper(int[][] grid, int col, int row, Map<Integer, Integer> map){
        int val = 0;
        Set<Integer> set = new HashSet<>();
        if(ingrid(grid, col-1, row) && grid[col-1][row] > 0){
            set.add(grid[col-1][row]);
        }
        if(ingrid(grid, col+1, row) && grid[col+1][row] > 0){
            set.add(grid[col+1][row]);
        }
        if(ingrid(grid, col, row-1) && grid[col][row-1] > 0){
            set.add(grid[col][row-1]);
        }
        if(ingrid(grid, col, row+1) && grid[col][row+1] > 0){
            set.add(grid[col][row+1]);
        }
        for(Integer num : set){
            if(map.get(num) != null)
                val += map.get(num);
        }
        return val + 1;
    }
    private int dfs(int[][] grid, int col, int row, int flag){
        if(!ingrid(grid, col, row))
            return 0;
        if(grid[col][row] != 1)
            return 0;
        grid[col][row] = flag;
        return 1 + dfs(grid, col - 1, row, flag) + dfs(grid, col + 1, row, flag) +
                dfs(grid, col, row - 1, flag) + dfs(grid, col, row + 1, flag);
    }
    private boolean ingrid(int[][] grid, int col, int row){
        if((col >= 0 && col  < grid.length) && (row >= 0 && row < grid[0].length))
            return true;
        return false;
    }
}
