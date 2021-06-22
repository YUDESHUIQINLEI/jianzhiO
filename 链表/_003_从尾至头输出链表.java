package 链表;
import java.util.LinkedList;

public class _003_从尾至头输出链表 {

    public static void main(String[] args) {
        Node head = new Node(3);
        Node a = new Node(1);
        Node b = new Node(2);
        int[] res = sortEndToStart(head);
        for(int num : res){
            System.out.println(num + " ");
        }
    }

    /**
     * 首先是从头到尾遍历链表，把个数统计好，建立一个对应数量的容器，把链表的数字放到容器中即可
     * @param head
     * @return
     */
    public static int[] sortEndToStart(Node head){
        int tmp = 0;
        Node node = head;
        while(node != null){
            tmp ++;
            node = node.next;
        }
        int[] res = new int[tmp];
        while(tmp >= 0 && head != null){
            res[-- tmp] = head.val;
            head = head.next;
        }
        return res;
    }
}