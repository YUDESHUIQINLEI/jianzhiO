package 搜索算法;

public class _053_在排序数组中查找数字 {
    /**
     * 统计一个数字在排序数组中出现的次数
     *
     * 想法：傻瓜式查找 一步一步找 时间复杂度高
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == target)
                ++ sum;
        }
        return sum;
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target){
        //首先查找右边界
        int i = 0, j = nums.length - 1;
        while(i <= j){
            int mid = (i + j) / 2;
            if(nums[mid] <= target) i = mid + 1;
            else j = mid - 1;
        }
        //i 此时就是右边界
        int right = i;
        if(j >= 0 && nums[j] != target) return 0;
        i = 0; j = nums.length - 1;
        while(i <= j){
            int mid = (i + j) / 2;
            if(nums[mid] >= target) j = mid - 1;
            else i = mid + 1;
        }
        //j就是左边界，就是target的前一位数
        int left = j;
        return right - left - 1;
    }
}
