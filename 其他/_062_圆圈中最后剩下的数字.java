package 其他;

public class _062_圆圈中最后剩下的数字 {
    /**
     * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字
     *
     * 想法：著名的约瑟夫环问题，最后剩余两个人,背诵就完了
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;
        //最后的时候剩余的是两人，反推，每次取余的分母就是剩余数组的长度；分子是遍历的数字m+上一轮结束的下标
        for(int i = 2; i <= n; i ++){
            ans = (ans + m) % i;
        }
        return ans;
    }
}
