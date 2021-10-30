package 排序;

public class testCase {
    public static void main(String[] args){
//        _051_数组中的逆序对 t = new _051_数组中的逆序对();
//        int[] nums = {3, 2, 1};
//        System.out.println(t.reversePairs(nums));
        _040_最小的K个数字 t = new _040_最小的K个数字();
        int[] nums = {8, 0, 3, 2, 5, 1};
        int[] res = t.getLeastNumbers(nums, 2);
        for(int num : res){
            System.out.print(num + " ");
        }
    }
}
