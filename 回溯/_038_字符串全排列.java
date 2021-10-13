package 回溯;

import java.util.*;

public class _038_字符串全排列 {
    public static void main(String[] args){
        String t = "aab";
        String[] res = permutation(t);
        for(String i : res){
            System.out.print(i + " ");
        }
    }
    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     *
     * 想法：深度优先遍历，一层一层向下找，当深度等于字符串长度的时候 就是满足条件
     * used用来存储是否访问过当前下标的元素 这样O(1)的时间就知道有没有访问过
     * path 用来存放当前已经添加的节点，回溯的时候 再删除；后面添加的时候还能重新添加
     * @param s
     * @return
     */
    public static String[] permutation(String s) {
        if(s.length() == 0)
            return null;
        List<String> res = new ArrayList<>();
        char[] data = s.toCharArray();
        int len = data.length;
        boolean[] used = new boolean[len];
        StringBuilder path = new StringBuilder();
        dfs(data, len, 0, path, used, res);
        return res.toArray(new String[res.size()]);
    }
    public static void dfs(char[] data, int len, int depth, StringBuilder path, boolean[] used, List<String> res){
        if(depth == len){
            if(res.contains(path.toString())){
                return;
            }
            res.add(path.toString());
            return;
        }
        for(int i = 0; i < len; i ++){
            if(used[i])
                continue;
            path.append(data[i]);
            used[i] = true;
            dfs(data, len, depth + 1, path, used, res);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }
}
