package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _114_二叉树展开为链表 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        _114_二叉树展开为链表 sol = new _114_二叉树展开为链表();
        sol.flatten(root);
        System.out.println(sol.levelOrder(root));
    }
    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *      展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     *      展开后的单链表应该与二叉树 先序遍历 顺序相同
     *
     * 想法：将左面的节点都插入到根节点的右子树中，本来的右子树嫁接到左子树最右边的节点
     * @param root
     */
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        while(root != null){
            if(root.left == null){
                root = root.right;
            }else{
                TreeNode left = root.left;
                while(left.right != null)
                    left = left.right; //一直向右面找哦 找啊找
                left.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return null;
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(! queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            while(size -- > 0){
                TreeNode node = queue.poll(); // 弹出当前的节点
                tmp.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
