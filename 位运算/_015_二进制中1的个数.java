package 位运算;

public class _015_二进制中1的个数 {
    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
     *
     * 想法：二进制数字减1，当前的位数字变成0，后面数字由0变为1，与减之前的数字做与操作，这样就把最右面的1干掉了；有几个这样的1，就可以被干掉几次
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count ++;
            n = n & (n - 1);
        }
        return count;
    }
}
