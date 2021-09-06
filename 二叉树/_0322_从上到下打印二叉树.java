package 二叉树;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0322_从上到下打印二叉树 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(levelOrder(root));
    }
    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
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
