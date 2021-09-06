package 二叉树;
import java.util.List;
import java.util.ArrayList;

public class _054_二叉搜索树的第K大节点 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.print(kthLargest(root, 1));
    }
    /**
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     *
     * 想法：二叉搜索树的中序遍历就是从小到大，找到其中第K大的节点值，其实就是第size()-k小的节点
     */
    public static int kthLargest(TreeNode root, int k) {
        if(root == null)
            return -1;
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        if(k > list.size()) return -1;
        return list.get(list.size() - k).val;
    }
    public static void inorder(TreeNode node, List list){
        if(node == null) return;
        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }
}
