package 二叉树;

public class _110_平衡二叉树 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        root.left = a;
        a.left = c;
        System.out.println(balanceTree(root));
        //System.out.println(balanceTree1(root));
    }
    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     */
    public static boolean balanceTree1(TreeNode root){
        if(root == null)
            return true;
        return Math.abs(height1(root.left) - height1(root.right)) <= 1 && balanceTree(root.left) && balanceTree(root.right);
    }
    public static int height1(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(height1(root.left), height1(root.right)) + 1;
    }
    public static boolean isBalance = true;
    public static boolean balanceTree(TreeNode root){
        if(root == null)
            return true;
        height(root);
        return isBalance == true;
    }
    public static int height(TreeNode root){
        if(root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) > 1){
            isBalance = false;
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
