package 二叉树;

public class _124_二叉树中的最大路径和 {
    /**
     * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
     *
     * 路径和 是路径中各节点值的总和。
     *
     * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
     *
     * 想法：用递归，自底向上，对于一个子树，最大和left+root+right；对于root的父节点，返回的是父节点+max(left, right)
     * @param root
     * @return
     */
    public int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        if(root == null)
            return 0;
        dfs(root);
        return sum;
    }
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        sum = Math.max(sum, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
