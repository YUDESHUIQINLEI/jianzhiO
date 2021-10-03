package 栈和队列;

public class _058_翻转单词顺序 {
    public static void main(String[] args){
        String s = "a good   example";
        System.out.print(reverseWords(s));
    }
    public static String reverseWords(String s) {
        String[] data = s.trim().split(" "); //首先是去掉首位的空格 再利用正则去掉单词中间的空格
        for(String tmp : data){
            System.out.print(tmp);    }
        System.out.println("-----------------------------");
        StringBuilder sb = new StringBuilder();
        for(int i = data.length - 1; i >= 0; i --){
            if(data[i].equals("")) //通过debug可以得知 空格split()之后变成""空的
                continue;
            sb.append(data[i] + " ");
        }
        return sb.toString().trim();
    }
}
