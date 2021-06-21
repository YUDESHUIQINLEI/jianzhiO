package 链表;

public class Node {
    public int val;
    public Node next;

    /**
     * 默认的构造函数
     */
    public Node(){

    }
    public Node(int val){
        this.val = val;
    }
    public Node(int val, Node node){
        this.val = val;
        this.next = node;
    }
}
