package 栈和队列;
import java.util.Stack;

public class _031_栈的压入弹出序列 {
    public static void main(String[] args){
        int[] pushed = {1, 0};
        int[] popped = {1, 0};
        System.out.println("后一个数组是否是前一个数组的输出: " + validateStackSequences(pushed, popped));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0; i < pushed.length; i ++) {
            stack.push(pushed[i]);
            while(j < popped.length && (! stack.isEmpty()) && stack.peek() == popped[j]){ //不要光想着数组下标的事儿 用peek之前看看栈空不空 要不就是空指针异常了啊呀
                stack.pop();
                j ++;
            }
        }
        if(j == popped.length){
            return true;
        }else{
            return false;
        }
    }
}
