package 其他;

public class _058_左旋转字符串 {
    public static void main(String[] args){
        String s = "abcdefg";
        int n = 2;
        String res = new _058_左旋转字符串().reverseLeftWords(s, n);
        System.out.println(res);
    }
    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"
     *
     * 想法：就是初始化StringBuilder，然后拼接，先拼接n后面的子字符串，再拼接n前面的子字符串。
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        if(n == 0 || n >= s.length())
            return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n, s.length()));
        sb.append(s.substring(0, n)); //左闭右开
        return sb.toString();
    }
}
