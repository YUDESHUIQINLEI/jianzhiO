package 宽度优先遍历;
import java.util.ArrayList;
import java.util.List;
import 二叉树.TreeNode;

public class _257_二叉树的所有路径 {
    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left = b; a.right = c;
        b.right = d;
        c.left = e; c.right = f;
        System.out.println(binaryTreePaths(a));
    }
    /**
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 想法：其实有几个到叶子结点的路径，就是找到有多少个叶子结点
     * 如果节点不为空的话，添加到当前节点的路径中，若这个节点是叶子节点则当前的一个路径就是一个叶子路径，然后回溯到上个节点，继续找右孩子，这个没有状态重置 不算回溯就是宽度遍历
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return null;
        List<String> res = new ArrayList<>();
        helper(root, "", res);
        return res;
    }
    public static void helper(TreeNode root, String path, List<String> res){
        if(root != null){
            path += Integer.toString(root.val);
            if(root.left == null && root.right == null){
                res.add(path);
            }else{
                path += "->";
                helper(root.left, path, res);
                helper(root.right, path, res);
            }
        }
    }
}
