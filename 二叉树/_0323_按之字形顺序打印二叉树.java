package 二叉树;
import java.util.*;

public class _0323_按之字形顺序打印二叉树 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(levelOrder(root));
    }
    /**
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if(root != null) queue.add(root);
            while(!queue.isEmpty()) {
                LinkedList<Integer> tmp = new LinkedList<>();
                for(int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    if(res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                    else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }
                res.add(tmp);
            }
            return res;

    }
}
