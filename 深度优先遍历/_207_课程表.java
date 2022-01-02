package 深度优先遍历;

import java.util.ArrayList;
import java.util.List;

public class _207_课程表 {
    public static void main(String[] args){
        _207_课程表 sol = new _207_课程表();
        int numCourses = 6;
        int[][] array = {{4,1},{2,1},{2, 1},{3,2},{4,2},{1, 4},{5, 3}};
        System.out.println(sol.canFinish(numCourses, array));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> acc = new ArrayList<>();
        for(int i = 0; i < numCourses; i ++)
            acc.add(new ArrayList<>());
        for(int[] ac : prerequisites)
            acc.get(ac[1]).add(ac[0]);
        int[] flags = new int[numCourses];
        for(int i = 0; i < numCourses; i ++){
            if(! dfs(acc, flags, i)){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> acc, int[] flags, int i) {
        if(flags[i] == -1)
            return true;
        if(flags[i] == 1)
            return false;
        flags[i] = 1;
        for(int j : acc.get(i)){
            if(! dfs(acc, flags, j)){
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }
}
