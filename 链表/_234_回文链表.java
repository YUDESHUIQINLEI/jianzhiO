package 链表;

public class _234_回文链表 {
    public static void main(String[] args){
        _234_回文链表 sol = new _234_回文链表();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        ListNode head1 = head;
        sol.scan(head1);
        System.out.println(sol.isPalindrome(head));
    }
    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     *
     * 想法💡：
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return false;
        if(head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow就是中间的指针
        slow = revert(slow.next);
        while(slow != null){
            if(head.val != slow.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode revert(ListNode head){
        if(head.next == null)
            return head;
        ListNode tommy = revert(head.next);
        head.next.next = head;
        head.next = null;
        return tommy;
    }
    private void scan(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
