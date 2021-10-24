package 动态规划;

public class _042_连续子数组的最大和 {
    public static void main(String[] args){
        int[] nums = {1, 4, -6, 9};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums){
        if(nums.length == 0)
            return 0;
        int res = nums[0];
        for(int i = 1; i < nums.length; i ++){
            nums[i] += Math.max(nums[i - 1], 0); //如果之前的数字和大于0，加到当前的数值上；如果之前的数字和小于0，则舍弃
            res = Math.max(res, nums[i]); //nums[i]目前为止到i的最大和
        }
        return res;
    }
}
