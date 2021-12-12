package 数组;
import java.util.ArrayList;
import java.util.List;
public class _078_子集 {
    public static void main(String[] args){
        int[] nums = {1, 2, 3};
        System.out.println(new _078_子集().subsets(nums));
    }
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res= new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        List<Integer> list = new ArrayList<>();
        dfs(0, nums, res, list);
        return res;
    }
    void dfs(int index, int[] nums, List<List<Integer>> res, List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i = index; i < nums.length; i ++){
            list.add(nums[i]);
            System.out.print("前面" + i + "--" + nums[i] + " ");
            dfs(i + 1, nums, res, list);
            System.out.print("后面" + i + "--" + nums[i]+ " ");
            list.remove(list.size() - 1);
            System.out.println();
        }
    }
}
