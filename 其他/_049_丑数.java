package 其他;

public class _049_丑数 {
    public static void main(String[] args){
        int n = 10;
        int res = new _049_丑数().nthUglyNumber(n);
        System.out.println(res);
        System.out.println();
        System.out.println(new _049_丑数().nthUGlyNumber(n));
    }
    /**
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     *
     * 下面的做法会造成超时，计算大数的时候会超时
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if(n == 0) return 0;
        int count = 1;
        int sum = 0;
        while(true){
            if(isUgly(count))
                ++ sum;
            if(sum == n)
                break;
            ++ count;
        }
        return count;
    }
    public boolean isUgly(int n){
        if(n == 1)
            return true;
        if(n == 0)
            return false;
        if(n % 2 == 0)
            return isUgly(n / 2);
        if(n % 3 == 0)
            return isUgly(n / 3);
        if(n % 5 == 0)
            return isUgly(n / 5);
        return false;
    }

    /**
     * 动态规划：用三个下标记录当前最小的丑数们，数组的下一个数字就是当前丑数中乘完2/3/5中最小的那个，等于的最小的那个也要下标+1，不断向下走
     * @param n
     * @return
     */
    public int nthUGlyNumber(int n){
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i ++){
            int Na = dp[a] * 2;
            int Nb = dp[b] * 3;
            int Nc = dp[c] * 5;
            dp[i] = Math.min(Math.min(Na, Nb), Nc);
            if(dp[i] == Na) a ++;
            if(dp[i] == Nb) b ++;
            if(dp[i] == Nc) c ++;
        }
        return dp[n - 1];
    }
}
