package 其他;

public class _021_调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        int[] res = new _021_调整数组顺序使奇数位于偶数前面().exchange(nums);
        for(int num : res){
            System.out.print(num + " ");
        }
    }
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分.
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if(nums== null || nums.length == 0)
            return new int[0];
        int i = 0;
        int j = nums.length - 1;
        while(true){
            System.out.println("'hahahhah'");
            while(i <= nums.length - 1 && isOdd(nums[i])){
                System.out.println(nums[i] + "我是奇数");
                i ++;
            }
            while(j >=0 && (! isOdd(nums[j]))){
                System.out.println(nums[j] + "我是偶数");
                j --;
            }
            if(i >= j)
                break;
            swap(nums, i, j); //这里面交换的一定要带下标，否则做的是无用功，交换的不是指定的数字
        }
        return nums;
    }
    public boolean isOdd(int num){
        if((num % 2) == 1)
            return true;
        return false;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
