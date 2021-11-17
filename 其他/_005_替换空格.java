package 其他;

public class _005_替换空格 {
    public static void main(String[] args){
        String s = "We are happy.";
        System.out.println(new _005_替换空格().replaceSpace(s));
    }
    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     * 想法：遇到一个空格，原有的长度就要+2，因为%20是三个字符，对应的赋值即可。
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        if(s == null || s.length() == 0)
            return "";
        char[] data = s.toCharArray();
        int count = 0;
        for(char tmp : data){
            if(tmp == ' '){
                count += 2;
            }
        }
        char[] result = new char[data.length + count];
        int index = 0;
        for(int i = 0; i < result.length; i ++){
            if(data[index] != ' '){
                result[i] = data[index ++];
            }else{
                result[i ++] = '%';
                result[i ++] = '2';
                result[i] = '0';
                index ++;
            }
        }
//        for(char tmp : result){
//            System.out.print(tmp);
//        }
        String newStr = new String(result, 0, data.length+count); //注意的是字符数组转换为字符串要用这个方法，否则输出的是乱码
        return newStr;
    }
}
