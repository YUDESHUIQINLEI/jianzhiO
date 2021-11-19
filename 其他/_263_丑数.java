package 其他;

public class _263_丑数 {
    public static void main(String[] args){
        int n = 6;
        boolean res = new _263_丑数().isUgly(n);
        System.out.println(res);
    }
    /**
     * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
     *
     * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
     *
     * 想法：只包含2、3、5，只能对这三个数字整除，如果有余数就代表不是丑数
     * @param n
     * @return
     */
    public boolean isUgly(int n) {
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
}
