package 栈和队列;
import java.util.Stack;

public class _232_用两个栈实现队列 {
    /** Initialize your data structure here. */
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;
    public _232_用两个栈实现队列() {
        stack1 = new Stack<>(); //主要的栈
        stack2 = new Stack<>(); //辅助的栈
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack1.isEmpty()){
            stack1.push(x);
        }else{
            while(! stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while(! stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(! stack1.isEmpty()){
            return stack1.pop();
        }else{
            throw new RuntimeException("此时栈为空，无法溢出值");
        }
    }

    /** Get the front element. */
    public int peek() {
        if(! stack1.isEmpty()){
            return stack1.peek();
        }else{
            throw new RuntimeException("此时栈为空，无法溢出值");
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
