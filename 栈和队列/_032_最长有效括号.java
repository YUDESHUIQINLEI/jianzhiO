package 栈和队列;

import java.util.Stack;

public class _032_最长有效括号 {
    public static void main(String[] args){
        System.out.println(new _032_最长有效括号().longestValidParentheses("()(()"));
    }
    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度
     *
     * 想法：设计一个开始入栈的元素 保证栈非空
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if(s==null || s.length() <= 1)
            return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); //放置一个作为栈底元素
        int sum = 0;
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i); //保证最后算括号的长度的时候 做差被减掉的那个数字是不被匹配最近的数字
                }else{
                    sum = Math.max(sum, i - stack.peek());
                }
            }
        }
        return sum;
    }
}
