package 滑动窗口;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class _239_滑动窗口最大值 {
    public static void main(String[] args){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new _239_滑动窗口最大值().maxSlidingWindow(nums, k);
        for(int num : res){
            System.out.print(num + " ");
        }
    }
    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回滑动窗口中的最大值
     *
     * 💡：用双端队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k < 1 || k > nums.length)
            return null;
        LinkedList<Integer> max = new LinkedList<>();
        int index = 0;
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i ++){
            while(! max.isEmpty() && nums[i] >= nums[max.peekLast()]){
                max.pollLast(); //只要新的值大等于队列中尾部的值，就更新队列中的值
            }
            max.addLast(i);
            if(max.peekFirst() == i - k)
                max.pollFirst(); //如果存入的值是最大值对应的下标 poll()出去
            if(i >= k - 1)
                res[index ++] = nums[max.peekFirst()];
        }
        return res;
    }
}
