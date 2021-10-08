package 位运算;

public class _136_只出现一次的数字 {
    public static void main(String[] args){
        int[] res = {1, 2, 1};
        System.out.println(singleNumber(res));
    }
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        if(nums.length == 0)
            return -1;
        int res = 0;
        for(int num : nums){
            res = res ^ num;
            System.out.println(res);
        }
        return res;
    }
}
