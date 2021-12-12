package 二叉树;

public class _096_不同的二叉搜索树 {
    public static void main(String[] args){
        int n = 3;
        System.out.println(new _096_不同的二叉搜索树().numTrees(n));
    }
    /**
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     *
     * 想法：互不相同的二叉树 就是根节点不同的二叉树。相加起来，每个二叉树的左面节点有(i-1)种选择；
     * 右面的节点有(n - i)中选择 二叉树的和就是笛卡尔积
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= n; i ++){
            for(int j = 1; j <= i; j ++){
                res[i] += res[j - 1] * res[i - j];
            }
        }
        return res[n];
    }
}
