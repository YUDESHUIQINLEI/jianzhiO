package 堆;

public class 快速排序 {
    public static void main(String[] args){
        int[] nums = {3, 0, 4, 1};
        int[] res = quickSort(nums);
        System.out.print("排序后的数组：");
        for(int num : res){
            System.out.print(num + " ");
        }
    }
    public static int[] quickSort(int[] array){
        if(array.length == 0)
            return new int[0];
        sort(array, 0, array.length - 1);
        return array;
    }

    public static void sort(int[] array, int low, int high){
        if(low >= high)
            return;
        int mid = partition(array, low, high);
        sort(array, low, mid - 1);
        sort(array, mid + 1, high);
    }
    public static int partition(int[] array, int low, int high){
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

    public static void swap(int[] array, int i ,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
