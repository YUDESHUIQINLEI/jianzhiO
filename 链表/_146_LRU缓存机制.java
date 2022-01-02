package 链表;

import java.util.HashMap;
import java.util.Map;

public class _146_LRU缓存机制 {
    public static void main(String[] args){
        _146_LRU缓存机制 sol = new _146_LRU缓存机制(2);
        sol.put(2, 2);
        sol.put(1, 1);
        System.out.println(sol.get(1));
        sol.put(3, 3);
        System.out.println(sol.get(2));
    }
    //定义一个双向脸变
    class ListNode{
        int key;
        int val; //存的是健值对
        ListNode pre;
        ListNode next;
        public ListNode(){

        }
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    Map<Integer, ListNode> map = new HashMap<>();
    ListNode preNode;
    ListNode tailNode;
    int capacity;
    int size;
    public _146_LRU缓存机制(int capacity){
        this.capacity = capacity;
        this.size = 0; //记录当前容器的规模
        preNode = new ListNode();
        tailNode = new ListNode();
        preNode.next = tailNode;
        tailNode.pre = preNode; //初始化链表
    }
    public int get(int key){
        ListNode node = map.get(key);
        if(node == null)
            return -1;
        moveToTop(node);
        return node.val;
    }
    public void put(int key, int value){
        ListNode node = map.get(key);
        if(node != null){
            node.val = value; //修改对应的值
            moveToTop(node); //变了就要去前面
        }else{
            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode);
            addToTop(newNode); //要放置在最前面
            ++ size;
            if(size > capacity){
                ListNode tail = deleteTail();
                map.remove(tail.key);
                -- size;
            }
        }
    }
    public ListNode deleteTail(){
        ListNode tail = tailNode.pre;
        deleteNode(tail);
        return tail;
    }
    public void moveToTop(ListNode node){
        deleteNode(node);
        addToTop(node);
    }
    public void deleteNode(ListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre; //双向指针
    }
    public void addToTop(ListNode node){
        node.next = preNode.next;
        preNode.next.pre = node;
        preNode.next = node;
        node.pre = preNode;
    }
}
