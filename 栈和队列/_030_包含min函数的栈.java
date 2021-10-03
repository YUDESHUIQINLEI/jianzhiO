package 栈和队列;
import java.util.*;
public class _030_包含min函数的栈 {
    /** initialize your data structure here. */
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;
    public _030_包含min函数的栈() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty() || x <= stack2.peek()){ //要么就是辅助栈为空的时候 要么就是新进的值小于当前最小的元素
            stack2.push(x);
        }
    }

    public void pop() {
        if(stack1.isEmpty()){
            throw new RuntimeException("当前的栈为空");
        }else{
            int y = stack1.pop();
            if(y == stack2.peek())
                stack2.pop();
        }
    }

    public int top() {
        if(stack1.isEmpty()){
            throw new RuntimeException("当前的栈为空");
        }else{
            return stack1.peek();
        }
    }

    public int min() {
        if(stack2.isEmpty()){
            throw new RuntimeException("当前的栈为空");
        }else{
            return stack2.peek();
        }
    }
}
