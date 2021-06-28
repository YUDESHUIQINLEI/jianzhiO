package 链表;

public class _056_删除链表中重复的结点 {
    public static void main(String[] args){
        Node head = new Node(1);
        Node a = new Node(1);
        Node b = new Node(1);
        head.next = a; a.next = b;
        Node res = deleteDuplicates(head);
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
     * 拙计想法：
     * @param head
     * @return
     */
    public static Node deleteDuplicates(Node head) {
        if(head == null || head.next == null)
            return head;
        Node node = head;
        while(node != null && node.next != null){
            if(node.val == node.next.val){
                Node tmp = node.next.next;
                node.next.next = null;
                node.next = tmp;
            }else
                node = node.next; //这里不能直接就next到下一个节点 否则连着多个重复的就坏了，应该加个判断条件
        }
        return head;
    }
}
