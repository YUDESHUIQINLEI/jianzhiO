package 堆;

public class testCase {
    public static void main(String[] args){
        _040_最小的k个数 k = new _040_最小的k个数();
        int[] nums = {3, 0, 4, -1, -2, 9};
        int[] res = k.quickSort(nums, 3);
        for(int num: res){
            System.out.print(num + " ");
        }

    }
}
