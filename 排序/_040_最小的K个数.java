package 排序;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _040_最小的K个数 {
    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     * 想法：利用快速排序后，排序好后按照顺序输出；或者利用堆排序 取出top值 本页面按照堆排序的算法取出值
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length <= 0 || k > arr.length)
            return null;
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int num : arr){
            if(queue.size() < k){
                queue.add(num);
            }else if(num < queue.peek()){ //如果小于当前的最小值
                queue.poll();
                queue.add(num);
            }
        }
        int[] res = new int[k];
        int id = 0;
        for(int num : queue){
            res[id ++] = num;
        }
        return res;
    }
}
