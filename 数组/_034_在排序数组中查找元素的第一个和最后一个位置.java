package 数组;

public class _034_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args){
        int[] nums = {1,2,3,3,4};
        int[] res = new _034_在排序数组中查找元素的第一个和最后一个位置().searchRange(nums, 3);
        for(int num : res){
            System.out.print(num + " ");
        }
    }
    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * 想法：二分法
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        int leftIndex = -1, rightIndex = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                int tmp = mid;
                while(tmp >=0 && nums[tmp] == target)
                    tmp --;
                leftIndex = tmp + 1;
                while(mid <= nums.length - 1 && nums[mid] == target)
                    mid ++;
                rightIndex = mid - 1;
                break;
            }
        }
        return new int[]{leftIndex, rightIndex};
    }
}
