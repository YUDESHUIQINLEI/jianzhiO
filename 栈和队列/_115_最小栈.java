package 栈和队列;
import java.util.Stack;
public class _115_最小栈 {
    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * push(x) —— 将元素 x 推入栈中。
     * pop() —— 删除栈顶的元素。
     * top() —— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
     *
     * 想法：初始化两个栈，一个放入所有的数字，一个放置小的数字；弹出的时候 若是等于小数 小数也弹出
     */
    public Stack<Integer> stack;
    public Stack<Integer> minStack;
    public _115_最小栈() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty())
            minStack.push(val);
        else if(minStack.peek() >= val) //这里容易错误，应该是同时判断的，否则就会导致入栈两次
            minStack.push(val);
    }

    public void pop() {
        if(stack.isEmpty())
            throw new RuntimeException("栈为空");
        int val = stack.pop();
        if(val == minStack.peek())
            minStack.pop();
    }

    public int top() {
        if(stack.isEmpty())
            throw new RuntimeException("栈为空");
        return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty())
            throw new RuntimeException("栈为空");
        return minStack.peek();
    }
}
