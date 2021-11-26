package 动态规划;

public class _005_最长回文子串 {
    public static void main(String[] args){
        String s = "aba";
        String res = new _005_最长回文子串().longestPalindrome(s);
        System.out.println(res);
    }
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     * 想法：回文子串就是从中间算对称的字符串.那将字符串reverse()对应相等的就是回文字符串
     * 动态规划 后一个值依赖前一个值
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s == "")
            return "";
        String reverse = new StringBuilder(s).reverse().toString(); //反转字符串
        int maxLen = 0;
        int endX = 0;
        int[] arr = new int[s.length()];
        for(int i = 0; i < s.length(); i ++){
            for(int j = s.length() - 1; j >= 0; j --){
                if(s.charAt(i) == reverse.charAt(j)){
                    if(j == 0)
                        arr[j] = 1;
                    else
                        arr[j] = arr[j - 1] + 1;
                }else{
                    arr[j] = 0;
                }
                if(arr[j] > maxLen){
                    System.out.println(j + "   " + arr[j]);
                    int before = s.length() - 1 - j;
                    if((before + arr[j] - 1) == i){ //判断下标是否能和i对应上
                        maxLen = arr[j];
                        endX = i;
                    }
                }
            }
        }
        return s.substring(endX - maxLen + 1, endX + 1); //左闭右开
    }
}
