package 回溯;
import java.util.*;

public class _017_电话号码的字母组合 {
    public static void main(String[] args){
        String digits = "23";
        List<String> res = new _017_电话号码的字母组合().letterCombinations(digits);
        System.out.println(res);
    }
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
     *
     *
     * @param digits
     * @return
     */
    public String[] letters = {"", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return res;
        int len = digits.length();
        perputation(res, digits, new StringBuilder(), 0);
        return res;
    }
    public void perputation(List<String> res, String digits, StringBuilder sb, int index){
        if(index == digits.length()){
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        int pos = c - '0'; //下标的位置
        String str = letters[pos];
        for(int i = 0; i < str.length(); i ++){
            sb.append(str.charAt(i));
            perputation(res, digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1); //删除最后面的字符
        }
    }
}
