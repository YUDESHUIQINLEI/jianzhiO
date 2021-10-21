package 回溯;

public class _013_机器人的运动范围 {
    /**
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     * 备注：1 <= n,m <= 100
     *      0 <= k <= 20
     * 想法：深度优先遍历，要有一个数组用来存储是否遍历过的状态
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        if(k == 0)
            return 1;
        boolean[][] visited = new boolean[m][n];
        return dfs(m, n, 0, 0, visited, k);
    }
    public int dfs(int m, int n, int i, int j, boolean[][] visited, int k){
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || (i / 10 + i % 10 + j / 10 + j % 10 > k))
            return 0;
        visited[i][j] = true;
        return dfs(m, n,i - 1, j, visited, k) + dfs(m, n, i + 1, j, visited, k) + dfs(m, n, i, j - 1, visited, k) + dfs(m, n, i, j + 1, visited, k) + 1;
    }
}
