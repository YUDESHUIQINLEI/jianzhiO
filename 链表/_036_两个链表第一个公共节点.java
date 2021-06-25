package 链表;

public class _036_两个链表第一个公共节点 {
    public static void main(String[] args){
        Node head1 = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node head2 = new Node(6);
        head1.next = a; a.next = b;
        head2.next = b;
        System.out.println(getIntersectionNode(head1, head2).val);
    }
    public static Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null)
            return null;
        int step1 = 0;
        int step2 = 0;
        Node tmp1 = headA;
        while(tmp1 != null){
            step1 ++;
            tmp1 = tmp1.next;
        }
        Node tmp2 = headB;
        while(tmp2 != null){
            step2 ++;
            tmp2 = tmp2.next;
        }
        int num;
        if(step1 > step2){
            num = step1 - step2;
            while(num -- > 0){
                headA = headA.next;
            }
        }else{
            num = step2 - step1;
            while(num -- > 0){
                headB = headB.next;
            }
        }
        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
