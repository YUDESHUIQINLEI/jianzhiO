package 其他;

public class _039_数组中出现次数超过一半的数字 {
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int res = new _039_数组中出现次数超过一半的数字().majorityElement(nums);
        System.out.println();
        System.out.println(res);
    }
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        // 利用快排对数组进行排序
        sort(nums, 0, nums.length - 1);
        for(int num : nums){
            System.out.print(num + " ");
        }
        return nums[nums.length / 2];
    }
    public void sort(int[] nums, int left, int right){
        if(left >= right)
            return;
        int mid = partition(nums, left, right);
        sort(nums, left, mid - 1);
        sort(nums, mid + 1, right);
    }
    public int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int i = left;
        int j = right + 1;
        while(true){
            while(++ i <= right && nums[i] < pivot);
            while(-- j >= left && nums[j] > pivot);
            if(i >= j)
                break;
            swap(nums, i, j);
        }
        nums[left] = nums[j];
        nums[j] = pivot;
        return j;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
