package 数组;

public class 二分法 {
    public static void main(String[] args){
        int[] arr = {12, 23, 34, 45, 56, 67, 77, 89, 90};
        二分法 solution = new 二分法();
        System.out.println(solution.search(arr, 45));
    }
    public int search(int[] arr, int key){
        int left = 0;
        int right = arr.length - 1;
        int res = -1;
        while(left + 1 < right){
            int mid = (left + right) / 2;
            System.out.println(left + "--" + mid + "--" + right);
            if(arr[mid] < key){
                left = mid;
            }else if(arr[mid] > key){
                right = mid;
            }else{
                res = mid;
                break;
            }
        }
        return res;
    }
}
