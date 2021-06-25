package 链表;

public class _055_链表中环的入口结点 {
    /**
     * 判断输入的链表中是否有环
     *
     * 拙计想法：走的快的指针能把走的慢的指针扣圈，就是有环;否则 就没有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode slower = head;
        ListNode faster = head;
        while(faster.next != null && faster.next.next != null){
            slower = slower.next;
            faster = faster.next.next;
            if(faster == slower)
                return true;
        }
        return false;
    }

    /**
     * 找到环的入口节点
     *
     * 拙计想法：两倍速的能比一倍速的多出一圈来，就是2x-x=n, x=n，慢的指针走的就是一圈的节点数目，整个长度-x=整个长度-n；也就是说头节点到环入口处=慢节点现在的位置到环入口处
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode slower = head;
        ListNode faster = head;
        while(faster.next != null && faster.next.next != null){
            slower = slower.next;
            faster = faster.next.next;
            if(faster == slower){
                faster = head;
                //这里有一个逻辑就是，如果入口处就在head，缺少一个判断条件，一直都找不到入口处
                if(faster == slower)
                    return slower;
                while(faster != slower){
                    faster = faster.next;
                    slower = slower.next;
                    if(slower == faster)
                        return slower;
                }
            }
        }
        return null;
    }

}
