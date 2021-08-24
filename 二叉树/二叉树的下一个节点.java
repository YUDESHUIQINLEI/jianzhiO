package 二叉树;

public class 二叉树的下一个节点 {
    public static void main(String[] args){
        TreeLinkNode root = new TreeLinkNode(8);
        TreeLinkNode a = new TreeLinkNode(2);
        TreeLinkNode b = new TreeLinkNode(6);
        TreeLinkNode c = new TreeLinkNode(4);
        TreeLinkNode d = new TreeLinkNode(5);
        root.left = a; root.right = b; a.next = root; b.next = root;
        a.left = c; a.right = d; c.next = a; d.next = a;
        System.out.println(GetNext(b).val);
    }
    /**
     * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针
     *
     * 想法：当前节点为空，直接返回null；当前节点存在右孩子，找到右孩子里面最左面的节点；若没有右孩子，向上找next，找到第一个父节点的左孩子是自己的节点
     */
    public static TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode == null)
            return null;
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        while(pNode.next != null){
            if(pNode.next.left == pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
class TreeLinkNode{
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
    public TreeLinkNode(int val){
        this.val = val;
    }
    public TreeLinkNode(int val, TreeLinkNode left, TreeLinkNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public TreeLinkNode(int val, TreeLinkNode left, TreeLinkNode right, TreeLinkNode next){
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}