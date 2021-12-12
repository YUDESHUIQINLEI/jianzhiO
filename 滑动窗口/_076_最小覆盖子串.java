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
        //ASCII表总长128
        int[] need = new int[128];
        int[] have = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int left = 0, right = 0, min = s.length() + 1, count = 0, start = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            if (need[r] == 0) {
                right++;
                continue;
            }
            //这个是怕某个元素在字符串s中重复的次数多余t
            if (have[r] < need[r]) {
                count++;
            }
            have[r]++;
            right++;
            while (count == t.length()) {
                System.out.print(s.substring(left, right) + " ");
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }
                char l = s.charAt(left);
                if (need[l] == 0) {
                    left++;
                    continue;
                }
                if (have[l] == need[l]) {
                    count--;
                }
                have[l]--;
                left++; //减小到就只剩恰好包含t字符串的s字符串
            }
            System.out.println();
        }
        if (min == s.length() + 1) {
            return "";
        }
        return s.substring(start, start + min);
    }
}
