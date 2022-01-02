package 数组;

public class 数组分解 {
    public static void main(String[] args){
        int[] nums = {2, 3, 5};
        数组分解 sol = new 数组分解();
        System.out.println(sol.divide(nums));

    }
    /**
     * 将一个数组分解为两个子数组 两个子数组的和差绝对值最小
     *
     * 想法💡：宗旨就是0-1背包问题
     * 想办法让背包中的数字和接近sum/2，剩下的数字和不就也接近sum/2了吗哈哈哈
     * 现在就是让背包往sum/2上面凑
     * @param nums
     * @return
     */
    public int divide(int[] nums){
        if(nums == null || nums.length == 0)
            return -1;
        int sum = 0;
        for(int num : nums)
            sum += num;
        int[] dp = new int[sum / 2 + 1];
        boolean[] state = new boolean[sum / 2 + 1];
        int tmp1 = 0, tmp2 = 0;
        for(int i = 0; i < nums.length; i ++){
            for(int j = sum / 2; j >= nums[i]; j --){
                if(dp[j] < (dp[j - nums[i]] + nums[i])){
                    dp[j] = dp[j - nums[i]] + nums[i];
                    tmp1 = dp[j - nums[i]];
                    tmp2 = nums[i];
                }
            }
            for(int num : dp)
                System.out.print(num + " ");
            System.out.println();
        }
        System.out.print(tmp1 + " " + tmp2);
        System.out.println();
        return sum - (dp[sum / 2]) * 2;
    }
}
