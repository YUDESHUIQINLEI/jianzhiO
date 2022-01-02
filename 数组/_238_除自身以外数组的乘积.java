package 数组;

public class _238_除自身以外数组的乘积 {
    /**
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
     * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
     *
     * 💡：其实如果能用除法，直接就是算完乘积除以自身就可以，再注意一下0的存在
     * 但是现在是要求O(n)时间复杂度，除了输出数组外O(1)空间复杂度
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length < 2)
            return null;
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for(int i = 1; i < nums.length; i ++)
            res[i] = res[i - 1] * nums[i]; //计算左面的乘积
        int tmp = 1;
        for(int i = nums.length - 1; i > 0; i --){
            res[i] = res[i - 1] * tmp; //计算左面的乘积 * 右面的乘积
            tmp *= nums[i];
        }
        res[0] = tmp;
        return res;
    }
}
