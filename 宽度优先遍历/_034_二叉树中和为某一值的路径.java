package 宽度优先遍历;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.List;

import apple.laf.JRSUIUtils;
import 二叉树.TreeNode;

public class _034_二叉树中和为某一值的路径 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(8);
        TreeNode c = new TreeNode(11);
        TreeNode d = new TreeNode(13);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(2);
        TreeNode h = new TreeNode(5);
        TreeNode i = new TreeNode(1);
        root.left = a; root.right = b;
        a.left = c; b.left = d; b.right = e;
        c.left = f; c.right = g; e.left = h; e.right = i;
        System.out.println(pathSum(root, 22));
    }
    /**
     * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     *
     * 想法：一个节点一个节点累加，到叶子结点并且和为目标值的时候满足条件；到叶子节点的时候，回到上个节点再去找右孩子，然后再回到上上个节点，这个时候就需要回溯哦，剪掉刚才的root并从栈中删除
     *
     * 容易犯错的地方：回溯只在不满足条件的时候回溯了，满足条件的时候没有进行状态重置，注意状态重置是要在同一个前提下哦！！！切记！！！
     */
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<Integer> path = new Stack<>();
        helper(root, target, 0, path, res);
        return res;
    }
    public static void helper(TreeNode root, int target, int sum, Stack<Integer> path, List<List<Integer>> res){
        if(root != null){
            path.add(root.val);
            sum += root.val;
            if(sum == target && root.left == null && root.right == null){
                res.add(new ArrayList<>(path));
            }else{
                helper(root.left, target, sum, path, res);
                helper(root.right, target, sum, path, res);
            }
            path.pop();
            sum -= root.val;
        }
    }
}
