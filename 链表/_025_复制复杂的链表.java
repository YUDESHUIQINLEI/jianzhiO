package 链表;

import java.util.HashMap;
import java.util.Map;

public class _025_复制复杂的链表 {
    /**
     * 深拷贝的话 引用对象需要copy一份新的，指向对象内存需要是一个新的 需要new
     *
     * 本题目前拙计的想法：借用容器，将random指针指向的节点存储下来，然后横向的复制好了之后，再把容器中的对象一一指出来
     * @param head
     * @return
     */
    public ListNode clone(ListNode head){
        if(head == null)
            return null;
        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode head1 = head;
        //这个是针对每个节点都new了
        while(head1 != null){
            map.put(head1, new ListNode(head1.val));
            head1 = head1.next;
        }
        //给链表节点分配指针啦
        head1 = head;
        while(head1 != null){
            map.get(head1).next = map.get(head1.next);
            map.get(head1).random = map.get(head1.random);
            head1 = head1.next;
        }
        return map.get(head);
    }
}
class ListNode{
    ListNode next = null;
    ListNode random = null;
    int val;
    public ListNode(){

    }
    public ListNode(int data){
        this.val = data;
    }
    public ListNode(int data, ListNode next){
        this.val = data;
        this.next = next;
        this.random = null;
    }
    public ListNode(int data, ListNode next, ListNode random){
        this.val = data;
        this.next = next;
        this.random = random;
    }
}
