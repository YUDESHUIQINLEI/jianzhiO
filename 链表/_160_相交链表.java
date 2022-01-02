package 链表;

public class _160_相交链表 {
    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     *
     * 想法💡：两个链表都遍历一遍 长的链表多走几步 再一起往后走
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode tmp1 = headA;
        ListNode tmp2 = headB;
        int len1 = 0;
        int len2 = 0;
        while(tmp1 != null){
            ++ len1;
            tmp1 = tmp1.next;
        }
        while(tmp2 != null){
            ++ len2;
            tmp2 = tmp2.next;
        }
        ListNode longer;
        ListNode slower;
        if(len1 > len2){
            longer = headA;
            slower = headB;
            while(len1 != len2){
                len1 --;
                longer = longer.next;
            }
        }else{
            longer = headB;
            slower = headA;
            while(len1 != len2){
                len2 --;
                longer = longer.next;
            }
        }
        //这里为了防止 一个节点本来就相交
        ListNode inter = slower;
        while(slower != longer){
            longer = longer.next;
            slower = slower.next;
            if(slower == longer){
                inter = slower;
                break;
            }
        }
        return inter;
    }
}
