package 数组;

public class _075_颜色分类 {
    public static void main(String[] args){
        int[] nums = {2,0,2,1,1,0};
        new _075_颜色分类().sortColors(nums);
        for(int num : nums){
            System.out.print(num + " ");
        }
    }
    /**
     * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
     *
     * 想法：其实就是输入0、1、2乱序的数组，原地修改，输出按照升序返回的数组
     */
    public void sortColors(int[] nums){
        if(nums == null || nums.length <= 0)
            return;
        int pos = 0;
        for(int i = 0; i < nums.length; i ++){
            //遇到0，就往前面置换，然后pos记录当前最后一个0位置的下一位
            if(nums[i] == 0){
                int tmp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = tmp;
                ++ pos;
            }
        }
        for(int i = 0; i < nums.length; i ++){
            //遇到1，就往前面置换，然后pos记录当前最后一个1位置的下一位
            if(nums[i] == 1){
                int tmp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = tmp;
                ++ pos;
            }
        }
    }
}
