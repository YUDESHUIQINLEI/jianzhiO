package 斐波那契;

public class 变态跳台阶 {
    /**
     * 变态跳台阶问题:每次可以跳一节，也可跳上两节......也可跳上n节，问有几种跳法？
     *
     * 想法：从后向前看，一下子跳n节，即一种；最后跳的是一节，就是n-1；最后跳两节，就是n-2；最后三节，就是n-3；……以此类推，相加的和
     *
     * 递归相加
     * @param n
     * @return
     */
    public int jumpFloor(int n){
        if(n == 0)
            return 1;
        if(n == 1)
            return 1;
        int m = 0;
        for(int i = 1; i <= n; i ++){
            m += jumpFloor(n - i); //
        }
        return m;
    }
}
