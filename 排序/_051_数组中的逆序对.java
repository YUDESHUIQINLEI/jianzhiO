package 排序;

public class _051_数组中的逆序对 {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     *
     * 想法：将数组拆开，拆开到最小元祖，比较两个数字的大小，统计逆序对，再归并；归并后再和后面的数组比较，如果一个数字比右面的数字大，那么前面数组后面的数字都比后面的数字大。
     * @param nums
     * @return
     */
    int count = 0;
    public int reversePairs(int[] nums) {
        if(nums.length <= 0 || nums == null)
            return this.count;
        merge(nums, 0, nums.length - 1);
        return this.count;
    }
    public void merge(int[] nums, int left, int right){
        int mid = left + (right - left) / 2;
        if(left < right){
            merge(nums, left, mid);
            merge(nums, mid + 1, right);
            mergeSort(nums, left, mid, right);
        }
    }
    public void mergeSort(int[] nums, int left, int mid, int right){
        int[] temp = new int[right - left + 1]; //构建一个装载递增顺序数字的数组
        int index = 0;
        int t1 = left, t2 = mid + 1;
        while(t1 <= mid && t2 <= right){
            if(nums[t1] <= nums[t2]){
                temp[index ++] = nums[t1 ++];
            }else{
                this.count += (mid - t1 + 1); //用来统计逆序对的个数
                temp[index ++] = nums[t2 ++];
            }
        }
        while(t1 <= mid){
            temp[index ++] = nums[t1 ++];
        }
        while(t2 <= right){
            temp[index ++] = nums[t2 ++];
        }
        for(int k = 0; k < temp.length; k ++){ //是要把排序好的数组赋值给原来的数组，否则会导致后面计算逆序对错误
            nums[left + k] = temp[k];
        }
    }
}
