package 链表;

public class _015_反转链表 {
    public static void main(String[] args){
        Node head = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        head.next = a; a.next = b;
        System.out.println(ReverseList(head).val);
    }

    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     * {1, 2, 3} 输出为 {3, 2, 1}
     *
     * 解决方式：双指针让后面的指向前面的, 但是有一个雷点，就是一定要有一个中间变量来记录pre.next节点，否则就是造成了恶性循环，一定要记住！！！！！
     * @param head
     * @return
     */
    public static Node ReverseList(Node head) {
        if(head == null || head.next == null)
            return head;
        Node cur = null;
        Node pre = head;
        while(pre != null){
            Node tmp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
        return cur;
    }
}
