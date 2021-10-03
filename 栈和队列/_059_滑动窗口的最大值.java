package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;

public class _059_滑动窗口的最大值 {
    public static void main(String[] args){
        int[] array = {1, 3, -1, -5, 3, 6, 7};
        int[] res = maxSlidingWindow(array, 3);
        for(int i : res){
            System.out.print(i + " ");
        }
    }

    /**
     * 解题思路：用一个协助的双端队列，队首放的是当前的最大值，队列非严格递减，当窗口开始向后移动的时候，如果队尾的元素比新进来的值小，就删除，保障队列中的元素是递减的
     *
     * 向后走的时候，前面走出去的元素要和双端队列对比，要是最大值的话，记得清除队首元素哦！！！
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0)
            return null;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for(int j = 0, i = 1 - k; j < nums.length; j ++, i ++){
            if(i > 0 && nums[i - 1] == queue.peekFirst())
                queue.removeFirst();
            // 找出比后面新入节点小的值要删除
            while(! queue.isEmpty() && queue.getLast() < nums[j])
                queue.removeLast();
            queue.addLast(nums[j]);
            if(i >= 0)
                res[i] = queue.getFirst();
        }
        return res;
    }
}
