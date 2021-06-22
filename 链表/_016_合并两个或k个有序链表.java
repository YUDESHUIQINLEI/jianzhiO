package 链表;

public class _016_合并两个或k个有序链表 {
    public static void main(String[] args){
        Node head = new Node(1);
        Node a = new Node(4);
        Node b = new Node(5);
        Node head1 = new Node(2);
        Node a1 = new Node(3);
        Node b1 = new Node(6);
        head.next = a; a.next = b;
        head1.next = a1; a1.next = b1;
        Node res = mergeTwoLists(head, head1);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     *
     * 解题思路：递归的思路，就是两个链表的第一个相比，小的那个在前面，进入下一轮，再看谁小，不断拼接到结束
     * @param l1
     * @param l2
     * @return
     */
    public static Node mergeTwoLists(Node l1, Node l2) {
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * @param lists
     * @return
     */
    public static Node mergeKLists(Node[] lists){
        if(lists == null || lists.length == 0)
            return null;
        int l = 0;
        int h = lists.length - 1;
        return merge(lists, l, h);
    }

    public static Node merge(Node[] lists, int left, int right){
        if(left == right)
            return lists[left];
        int mid = left + (right - left) / 2;
        Node l1 = merge(lists, left, mid);
        Node l2 = merge(lists, mid+1, right);
        return mergeTwoLists(l1, l2);
    }
}
