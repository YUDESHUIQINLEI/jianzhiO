package 回溯;

public class _012_矩阵中的路径 {
    public static void main(String[] args){
        char[][] board = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};
        System.out.println(exist(board, "abed"));
    }
    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     * 想法：也是回溯 暴力回溯 每个节点作为起始节点，四周的方向开始寻找
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                if(dfs(board, i, j, 0, words))
                    return true;
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board, int i, int j, int k, char[] words){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[k])
            return false;
        if(k == words.length - 1)
            return true;
        board[i][j] = ' ';
        boolean res = dfs(board, i - 1, j, k +1, words) || dfs(board, i + 1, j, k + 1, words)
                || dfs(board, i, j - 1, k + 1, words) || dfs(board, i, j + 1, k + 1, words);
        board[i][j] = words[k]; //回溯到之前的状态 k也在增加
        return res;
    }
}
