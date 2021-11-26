package 链表;

public class _002_两数相加 {
    public static void main(String[] args){
        Node l1 = new Node(2);
        l1.next = new Node(3);
        Node l2 = new Node(4);
        l2.next = new Node(5);
        System.out.println(new _002_两数相加().addTwoNumbers(l1, l2).val);
    }
    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
     *
     * 想法：就是两个数字相加，有进位向前进位，因为正好是逆序排序
     * @param l1
     * @param l2
     * @return
     */
    public Node addTwoNumbers(Node l1, Node l2) {
        Node pre = new Node(0);
        Node cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null){ //两个节点的值不为空 就能继续向下走
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0: l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new Node(sum % 10);
            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        return pre.next;
    }
}
