package 数组;

import java.util.HashSet;
import java.util.Set;

    public class _128_最长连续序列 {
    public static void main(String[] args){
        int[] nums = {100,4,200,1,3,2};
        _128_最长连续序列 solution = new _128_最长连续序列();
        System.out.println(solution.longestConsecutive(nums));
    }
    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题
     *
     * 想法💡 先不按照O(n) 先排序，再顺序遍历找满足条件的连续数字
     *
     * 如果按照O(n)的话 满足k*n 借助空间
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num); //直接去重
        int longest = 0;
        for(int num : set){
            if(!set.contains(num -1)){ //找到连续中最小的数字 不做无谓遍历
                System.out.print("当前数字" + num + "   ");
                int cur = num;
                int longer = 1;
                while(set.contains(cur + 1)){
                    longer += 1;
                    cur += 1;
                    System.out.print(cur);
                }
                System.out.println();
                longest = Math.max(longest, longer);
            }
        }
        return longest;
    }
}
