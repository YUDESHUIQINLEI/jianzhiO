package 二叉树;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class _0321_从上到下打印二叉树 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        int[] res = levelOrder(root);
        for(int i = 0; i < res.length; i ++){
            System.out.print(res[i] + " ");
        }
    }
    /**
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     */
    public static int[] levelOrder(TreeNode root) {
        if(root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.add(root);
        //只要是非空的 就能证明还有节点哦
        while(! queue.isEmpty()){
            TreeNode node = queue.poll();
            res.add(node.val); //添加数据到结果中
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
        int[] res1 = new int[res.size()];
        for(int i = 0; i < res.size(); i ++){
            res1[i] = res.get(i);
        }
        return res1;
    }
}
