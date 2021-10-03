package 栈和队列;

public class testCase {
    public static void main(String[] args){
        _232_用两个栈实现队列 queue = new _232_用两个栈实现队列();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());

        _030_包含min函数的栈 minStack = new _030_包含min函数的栈();
        minStack.push(3);
        minStack.push(2);
        minStack.push(-1);
        minStack.push(-1);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}
