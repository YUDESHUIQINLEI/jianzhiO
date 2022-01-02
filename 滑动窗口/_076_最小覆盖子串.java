package 滑动窗口;

public class _076_最小覆盖子串 {
    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = new _076_最小覆盖子串().minWindow(s, t);
        System.out.println(res);
    }
    public String minWindow(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
        int[] map = new int[256];
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        for(char ch : ch2)
            map[ch] ++; //需要s补偿的字符
        int match = ch2.length;
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int res = 0;
        while(right != ch1.length){
            map[ch1[right]] --;
            if(map[ch1[right]] >= 0)
                match --;
            if(match == 0){
                while(map[ch1[left]] < 0){
                    map[ch1[left ++]] ++;
                }
                if((right - left + 1) < minLen){
                    minLen = right - left + 1;
                    res = left;
                }
                match ++;
                map[ch1[left ++]] ++;
            }
            right ++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(res, res + minLen);
    }
}
