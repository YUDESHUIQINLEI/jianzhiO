package 二叉树;

public class _004_重建二叉树 {
    /**
     * 通过前序遍历数组和中序遍历数组构造二叉树
     *
     * 解题方法：前序数组的首个元素就是二叉树的跟节点，在中序遍历中找到跟节点，左边就是左子树，右边就是右子树，往复循环，分治法能实现二叉树的构建
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null)
            return null;
        return re(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode re(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(pre[preStart]);
        for(int i = inStart; i <= inEnd; i ++){
            if(pre[preStart] == in[i]){
                root.left = re(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                root.right = re(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
            }
        }
        return root;
    }
}
