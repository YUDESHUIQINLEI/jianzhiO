package 其他;

public class _057_和为s的两个数字 {
    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int[] res = new _057_和为s的两个数字().twoSum(nums, 10);
        for(int num : res){
            System.out.print(num + " ");
        }
    }
    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     * 想法：两个下标，一个在最左面，一个在最右面，相加的话大于目标值，右面的向前移动；反之，最左面的值向后移动
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return null;
        int i = 0, j = nums.length - 1;
        int[] res = new int[2];
        while(i < j){
            if(nums[i] + nums[j] < target){
                i ++;
            }else if(nums[i] + nums[j] > target){
                j --;
            }else{
                res[0] = nums[i];
                res[1] = nums[j];
                break;
            }
        }
        return res;
    }
}
