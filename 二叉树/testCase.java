package 二叉树;
import apple.laf.JRSUIUtils;
import 二叉树._036_二叉搜索树与双向链表;
import 二叉树._110_平衡二叉树;
import 二叉树._028_对称的二叉树;

public class testCase {
    public static void main(String[] args){
//        Node root = new Node(4);
//        Node a = new Node(2);
//        Node b = new Node(1);
//        Node c = new Node(3);
//        Node d = new Node(5);
//        root.left = a; root.right = d;
//        a.left = b; a.right = c;
//        Node res = new _036_二叉搜索树与双向链表().treeToDoublyList(root);
//        System.out.println(res.val);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        System.out.print(new _028_对称的二叉树().isSymmetric(root));
    }
}
