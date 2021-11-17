package 其他;

public class _043_1至n整数中1出现的次数 {
    public static void main(String[] args){
        int n = 12;
        System.out.println(new _043_1至n整数中1出现的次数().countDigitOne(n));
    }
    /**
     * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
     *
     * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
     *
     * 想法：这道题目没别的 就是背诵就完了
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int res = 0, digit = 1;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0){
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + 1 + low;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
