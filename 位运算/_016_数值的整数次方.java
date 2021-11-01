package 位运算;

public class _016_数值的整数次方 {
    public static void main(String[] args){
        double x = 3;
        int n = 2;
        System.out.println(myPow(x, n));
    }
    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
     *
     * 想法：要考虑到n是负数的时候
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(x == 0)
            return 0;
        long b = n;
        double result = 1.0;
        if(b < 0){ //考虑到n是负数的时候
            x = 1 / x;
            b = -b;
        }
        while(b > 0){
            if((b & 1) == 1)
                result *= x;
            x *= x;
            b >>= 1;
        }
        return result;
    }
}
