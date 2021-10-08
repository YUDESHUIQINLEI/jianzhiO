package 斐波那契;

public class _010_青蛙跳台阶 {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     * 有n-1种方式走剩下的一个台阶，n-2种走剩下的两个台阶，就是斐波那契
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n == 0)
            return 1;
        if(n == 1)
            return 1;
        int a = 1, b = 1;
        int sum = 0;
        for(int i = 2; i <= n; i ++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }
}
