package 斐波那契;

public class _010_斐波那契数列 {
    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        int a = 0, b = 1;
        int sum = 0;
        for(int i = 2; i <= n; i ++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }
}
