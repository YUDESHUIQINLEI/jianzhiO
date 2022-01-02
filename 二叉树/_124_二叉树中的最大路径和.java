package 二叉树;

public class _124_二叉树中的最大路径和 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        _124_二叉树中的最大路径和 sol = new _124_二叉树中的最大路径和();
        System.out.println(sol.maxPathSum(root));
    }
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
        System.out.println(root.val + Math.max(left, right));
        return root.val + Math.max(left, right); //这里取得是最大值而不是和，是因为一个节点只能走一次
    }
}
