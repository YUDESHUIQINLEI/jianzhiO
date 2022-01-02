package 动态规划;
import java.util.*;

public class _139_单词拆分 {
    public static void main(String[] args){
        _139_单词拆分 sol = new _139_单词拆分();
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("leetc");
        wordDict.add("ode");
        System.out.println(wordDict);
        System.out.println(sol.breakWord(s, wordDict));
    }

    /**
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典，判定 s 是否可以由空格拆分为一个或多个在字典中出现的单词。
     *
     * 说明：拆分时可以重复使用字典中的单词。
     *
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean breakWord(String s, List<String> wordDict){
        Set<String> set = new HashSet<>(wordDict); //可以重复使用
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 1; i <= n; i ++){
            for(int j = 0; j < i; j ++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    System.out.print(s.substring(j, i) + "--" + j + " " + i +"   ");
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
