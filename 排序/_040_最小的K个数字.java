package 排序;

public class _040_最小的K个数字 {
    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     * 想法：利用快速排序后，排序好后按照顺序输出；或者利用堆排序 取出top值 本页面按照快排 利用快排的方法
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr);
        int[] res= new int[k];
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
        int id = 0;
        for(int i = 0; i < k; i ++){
            res[id] = arr[id ++];
        }
        return res;
    }
    public void quickSort(int[] arr){
        sort(arr, 0, arr.length - 1);
    }
    public void sort(int[] arr, int left, int right){
        if(left >= right)
            return;
        int mid = partition(arr, left, right);
        sort(arr, left, mid - 1);
        sort(arr, mid + 1, right);
    }
    public int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low, j = high + 1;
        while(true){
            while(++ i <= high && arr[i] < pivot);
            while(-- j >= low && arr[j] > pivot);
            if(i >= j)
                break;
            swap(arr, i, j);
        }
        arr[low] = arr[j];
        arr[j] = pivot;
        return j;
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
