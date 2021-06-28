package 二叉树;

public class _017_树的子结构 {
    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     *
     * 想法：遍历二叉树，遍历到节点值=B根节点值的，开始比较该节点下面的节点值和B的是不是匹配
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null)
            return false;
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean recur(TreeNode A, TreeNode B){
        if(B == null)
            return true;
        if(A == null || A.val != B.val)
            return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
