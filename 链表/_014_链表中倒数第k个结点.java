package 链表;

public class _014_链表中倒数第k个结点 {
    public static void main(String[] args){
        Node head = new Node(1);
        Node a = new Node(3);
        Node c = new Node(4);
        Node d = new Node(2);
        head.next = a; a.next = c; c.next = d;
        Node res = findKthNode(head, 7);
        System.out.println(res.val);
    }
    /**
     * 倒数第K个节点，其实就是两个指针一起向前走，其中一个快了K步，等前面的指针指向最后一个节点的时候，后面的指针指向的就是倒数的第K个节点
     * @param head
     * @param val
     * @return
     */
    public static Node findKthNode(Node head, int val){
        Node node = head;
        if(val <= 0)
            return null; //要增加对边界条件的判断
        while(-- val > 0){
            if(node.next != null)
                node = node.next;
            else
                throw new RuntimeException("链表元素少于要求的倒数的数字");
        }
        while(node.next != null){
            node = node.next;
            head = head.next;
        }
        return head;
    }
}