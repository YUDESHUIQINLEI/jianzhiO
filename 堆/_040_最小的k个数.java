package 堆;
import java.util.*;
public class _040_最小的k个数 {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        _040_最小的k个数 solution = new _040_最小的k个数();
        System.out.println(solution.ktkLarger(arr, 5));
    }
    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     * 题解：利用java中的数据结构 堆
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0 || arr.length == 0)
            return new int[0];
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int num : arr){
            if(queue.size() < k){
                queue.add(num);
            }else if(num < queue.peek()){
                queue.poll();
                queue.add(num);

            }
        }

        int[] res = new int[k];
        int id = 0;
        for(int num : queue)
            res[id ++] = num;
        return res;
    }

    //第K个大的数字
    public int ktkLarger(int[] nums, int k){
        if(k == 0 || nums.length == 0 )
            return 0;
        if(k > nums.length)
            throw new RuntimeException("数组长度不足k");
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; //升序
            }
        });
        return nums[nums.length - k];
    }

    //利用快排
    public int[] quickSort(int[] array, int k){
        if(array.length == 0|| k == 0)
            return new int[0];
        return sort(array, 0, array.length - 1, k - 1);
    }

    public int[] sort(int[] array, int low, int high, int k){
        int mid = partition(array, low, high);
        if(mid == k)
            return Arrays.copyOf(array, mid + 1);
        return mid > k ? sort(array, low, mid - 1, k) : sort(array, mid + 1, high, k);
    }
    public int partition(int[] array, int low, int high){
        int pivot = array[low];
        int i = low, j = high + 1;
        while(true){
            while(++ i <= high && array[i] < pivot);
            while(-- j >= low && array[j] > pivot);
            if(i >= j)
                break;
            swap(array, i, j);
        }
        array[low] = array[j];
        array[j] = pivot;
        return j;
    }

    public void swap(int[] array, int i ,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
