package 二叉树;

public class _018_二叉树的镜像 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(4);
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(6);
        root.left = a; root.right = b;
        System.out.println(mirrorTree(root).right.val);
    }
    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     *
     * 想法：就是递归 递归到最下面 反转左右子树；再往上层反转，一直到最上层, 翻转左右子树
     * @param root
     * @return
     */
    public static TreeNode mirrorTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
