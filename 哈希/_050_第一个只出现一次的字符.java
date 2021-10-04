package 哈希;

import java.util.*;

public class _050_第一个只出现一次的字符 {
    public static void main(String[] args){
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
        System.out.print(firstUniqChar1(s));
    }
    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     */
    public static char firstUniqChar(String s) {
        if(s.length() == 0)
            return ' ';
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i ++){
            if(! map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }else{
                int j = map.get(s.charAt(i));
                map.put(s.charAt(i), ++ j);
            }
        }
        for(Map.Entry<Character, Integer> time : map.entrySet()){
            System.out.println("Key = " + time.getKey() + "; Value = " + time.getValue());
        }
        // 注意一下，这里访问的时候不能顺序去遍历map，因为map存储数据不会记录插入的顺序，要通过遍历字符串哪个值是1，就是第一个只出现1次的字符
        for(int i = 0; i < s.length(); i ++){
            if(map.get(s.charAt(i)) == 1)
                return s.charAt(i);
        }
        return ' ';
    }

    public static char firstUniqChar1(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }

}
