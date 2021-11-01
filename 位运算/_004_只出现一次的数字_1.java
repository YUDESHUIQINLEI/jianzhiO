package 位运算;

public class _004_只出现一次的数字_1 {
    public static void main(String[] args){
        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(singleNumber(nums));
    }
    /**
     * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     *
     * 通过将数字分解为位数，将它们进行累加，每位数进行对3取余，最后的数字就是单独出现的那个
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int[] binary = new int[32];
        for(int i = 0; i < nums.length; i ++){
            int temp = 1; //用来帮助每个位数上面的赋值
            for(int j = 31; j >= 0; j --){
                if((nums[i] & temp) != 0)
                    binary[j] ++;
                temp<<=1;
            }
        }
        int res = 0;
        for(int num : binary){
            res <<= 1; //先左移 再相加 因为是新一个位数的值
            if((num % 3) != 0)
                res += (num % 3);
        }
        return res;
    }
}
