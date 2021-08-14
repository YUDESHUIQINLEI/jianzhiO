package 宽度优先遍历;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _46_全排列 {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *
     *
     */
    public static void main(String[] args){
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    /**
     * 使用的深度遍历，一层一层深入，就是有个状态记录走到第几层，层数=深度时，往回走
     * 用一个栈记录进来哪些节点了，用一个数组记录访问了哪些点了(更快速的知道哪些点被访问了)
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0 || nums == null)
            return null;
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        dfs(nums, len,0, path, used, res);
        return res;
    }
    public static void dfs(int[] nums, int len, int depth, Stack<Integer> path, boolean[] used, List<List<Integer>> res){
        if(depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < len; i ++){
            if(used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, res);
            path.pop();
            used[i] = false;
        }
    }
}