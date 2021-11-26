package 数组;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
public class _015_三数之和 {
    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = new _015_三数之和().threeSum(nums);
        System.out.println();
        System.out.println(res);
    }
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     *
     * 想法：是动态的指针哦，一个固定在最左面，两个一个在左面+1，一个在右面，判断三个数字的和来移动指针
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null || nums.length < 3)
            return res;
        Arrays.sort(nums); //给数组排序 nlogn
        for(int num : nums){
            System.out.print(num + " ");
        }
        for(int k = 0; k < nums.length - 2; k ++){
            if(nums[k] > 0) //已经是排序的数组 如果左面的为止大于0，后面的肯定大于0
                break;
            if((k > 0) && (nums[k] == nums[k - 1])) //对于已经相等的 就没有必要重复遍历了
                continue;
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    while((i < j) && (nums[i] == nums[++ i])); //如果是相等的话 就继续向前面走
                }else if(sum > 0){
                    while((j > i) && (nums[j] == nums[-- j]));
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    while((i < j) && (nums[i] == nums[++ i]));
                    while((j > i) && (nums[j] == nums[-- j]));
                }
            }
        }
        return res;
    }
}
