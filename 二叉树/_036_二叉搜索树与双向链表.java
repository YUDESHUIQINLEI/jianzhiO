package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class _036_二叉搜索树与双向链表 {
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     */
    public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        List<Node> list = new ArrayList<>();
        inorder(root, list);
        Node head = list.get(0);
        Node ptr = head; //链表头
        head.left = list.get(list.size() - 1);
        list.get(list.size() - 1).right = head;
        for(int i = 1; i < list.size(); i ++){
            ptr.right = list.get(i);
            list.get(i).left = ptr;
            ptr = ptr.right;
        }
        return head;
    }
    public void inorder(Node root, List<Node> list){
        if(root == null)
            return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

    public Node head;
    public Node pre;
    //更加精简的方法 不用借助链表
    public Node treeToList(Node root){
        if(root == null)
            return null;
        Inorder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    public void Inorder(Node root){
        if(root == null) return;
        Inorder(root.left);
        if(pre != null) pre.right = root;
        else head = root;
        root.left = pre;
        pre = root;
        Inorder(root.right);
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};