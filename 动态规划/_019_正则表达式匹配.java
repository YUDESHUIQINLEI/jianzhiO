package 动态规划;

public class _019_正则表达式匹配 {
    public static void main(String[] args){
        String s = "aaa";
        String p = "ab*a";
        System.out.println(isMatch(s, p));
    }
    /**
     * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配
     *
     * 思路：首先当碰到*号的时候 想到几种情况：*号前面的字符=字符串的字符，要么*=1，要么还停在*让*前面的字符多用几次，要么*=0
     * *前面的字符！=字符串的字符 直接当作0处理
     * 如果没有碰到*，就直接判断字符是否相等，或者是模式中有·
     *
     * 注意：越界问题，一定要看j+1是不是超过p的范围 还有i对于s的范围
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if(s == null || p == null)
            return false;
        return helper(s, 0, p, 0);
    }
    public static boolean helper(String s, int i, String p, int j){
        if(i == s.length() && j == p.length())
            return true;
        if(i != s.length() && j == p.length()) //能匹配的已经用完了
            return false;
        if(((j + 1) < p.length()) && (p.charAt(j + 1) == '*')){
            if(i == s.length())
                return helper(s, i, p, j+2);
            if(s.charAt(i) == p.charAt(j) || (s.charAt(i) != ' ' && p.charAt(j) == '.')){
                return helper(s, i + 1, p, j + 2) || //* 当作1
                        helper(s, i + 1, p, j) || //*当作多个
                        helper(s, i, p, j + 2); //*当作0次 比如aa aa*a
            }
            else
                return helper(s, i, p, j + 2); //直接当0处理
        }
        if(i >= s.length())
            return false;
        if(s.charAt(i) == p.charAt(j) || (s.charAt(i) != ' ' && p.charAt(j) == '.'))
            return helper(s, i + 1, p, j + 1);
        return false;
    }
}
