package 数组;

public class 找到最左目标值 {
    public static void main(String[] args){
        int[] nums = {0, 0, 1, 1, 1, 2};
        int target = 2;
        System.out.println(new 找到最左目标值().findNum(nums, target));
    }
    /**
     * 找到升序数组中等于目标值的最左侧索引，要最左面等于目标值的下标
     *
     * 想法💡：
     * @param nums
     * @param target
     * @return
     */
    public int findNum(int[] nums, int target){
        if(nums == null || nums.length == 0)
            throw new RuntimeException("数组为空");
        if(target > nums[nums.length - 1] || target < nums[0])
            return -1;
        int i = 0, j = nums.length - 1;
        while(i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] >= target) j = mid - 1;
            else i = mid + 1;
        }
        System.out.println(i);
        return nums[i] == target ? i : -1;
    }
}
