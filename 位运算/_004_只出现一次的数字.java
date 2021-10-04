package 位运算;

public class _004_只出现一次的数字 {
    public static void main(String[] args){
        int[] nums = {2, 3, 2, 2};
        System.out.println(singleNum(nums));
    }
    /**
     * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     *
     */
    public static int singleNum(int[] nums){
        if(nums == null || nums.length == 0)
            return -1;
        int[] binary = new int[32]; //数组存储的是各个位上面的数字和
        for(int i = 0; i < nums.length; i ++){
            int temp = 1;
            for(int j = 31; j >= 0; j --){
                int num = nums[i] & temp;
                System.out.println(num);
                if(num != 0)
                    binary[j] += 1;
                temp = temp << 1;
            }
            for(int t : binary){
                System.out.print(t + " ");
            }
            System.out.println("-------------------------------");
        } // 按照位数相加

        int res = 0;
        for(int bit : binary){
//            res = res << 1;
//            res += bit % 3;
            if(bit % 3 != 0)
                res = res << 1;
                res += bit % 3;
        }
        return res;
    }
}
