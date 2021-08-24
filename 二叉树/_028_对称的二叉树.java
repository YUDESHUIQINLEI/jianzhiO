package 二叉树;

public class _028_对称的二叉树 {
    /**
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     *
     * 要求同时为空 或者同时不为空且值相等 才能满足对称的要求
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return recur(root.left, root.right);
    }
    public boolean recur(TreeNode L, TreeNode R){
        if(L == null && R == null)
            return true;
        if(L == null || R == null || L.val != R.val)
            return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
