package 回溯;
import java.util.*;
public class _022_括号生成 {
    public static void main(String[] args){
        int n = 3;
        List<String> res = new _022_括号生成().generateParenthesis(n);
        System.out.println(res);
    }
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 有效括号组合需满足：左括号必须以正确的顺序闭合。
     *
     * 想法：左面和右面的闭合 首先就是先拼接左括号 把左面能用的数字减1；再拼接右括号
     * 如果左面剪完还比右面的数字大 就要剪枝；后面的不够拼接
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0)
            return res;
        dfs(res, n, n, new StringBuilder());
        return res;
    }
    void dfs(List<String> res, int left, int right, StringBuilder sb){
        if(left == 0 && right == 0){
            res.add(sb.toString());
            return;
        }
        if(left > right)
            return;
        if(left > 0){
            sb.append('(');
            dfs(res, left - 1, right, sb);
            sb.deleteCharAt(sb.length() - 1); //拼接完删除 删除就删除最新拼接的那个
        }
        if(right > 0){
            sb.append(')');
            dfs(res, left, right - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
