package 其他;

public class _031_下一个排列 {
    public static void main(String[] args){
        int[] nums = {1, 3, 6, 5, 4, 1};
        new _031_下一个排列().nextPermutation(nums);
        for(int num : nums){
            System.out.print(num + " ");
        }
    }
    /**
     * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
     *
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     *
     * 必须 原地 修改，只允许使用额外常数空间。
     *
     * 想法：首先从右面开始找 第一对前面的数字小于后面的数字的 和右面第一个比他大的数字交换 再reverse使得新的排列里面数字升序排列
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1)
            return;
        int i = nums.length - 1;
        int j = nums.length - 2;
        while(j >= 0 && nums[j] >= nums[i]){
            j --;
            i --;
        } //找到j就是第一对小的数字
        if(j >= 0){
            int k = nums.length - 1;
            while(nums[j] >= nums[k]){
                k --;
            } //找到比他大的最近邻的那个小大数
            swap(nums, j, k);
        }
        reverse(nums, j + 1); //将后面的数字设置为升序
    }
    void reverse(int[] nums, int start){
        int left = start, right = nums.length - 1;
        while(left < right){
            swap(nums, left, right);
            ++ left;
            -- right; //从中间划分 左面的数字小于右面的数字
        }
    }
    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
