package 其他;

public class _066_构建乘积数组 {
    public static void main(String[] args){
        int[] a = {1, 2, 3, 4, 5};
        int[] res = new _066_构建乘积数组().constructArr(a);
    }
    /**
     * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
     * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法
     *
     * 想法：如果是暴力解法，会直接导致时间超时；构建一个二维乘积数组，中间的数字是1
     * @param a
     * @return
     */
    public int[] constructArr(int[] a){
        if(a.length == 0)
            return new int[0];
        int[] res = new int[a.length];
        res[0] = 1;
        int tmp = 1;
        System.out.println("乘完左下角所有数字的乘积：");
        for(int i = 1; i < a.length; i ++){
            res[i] = res[i - 1] * a[i - 1]; //res数组存储的是下面的三角形数字的乘积
        }
        for(int num : res){
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("乘完右上角所有数字的乘积：");
        for(int i = a.length - 2; i >=0; i --){
            tmp *= a[i + 1];
            res[i] *= tmp;
        }
        for(int num : res){
            System.out.print(num + " ");
        }
        return res;
    }
}
