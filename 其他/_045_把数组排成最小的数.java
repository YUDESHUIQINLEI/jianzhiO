package 其他;

public class _045_把数组排成最小的数 {
    public static void main(String[] args){
        int[] nums = {3,30,34,5,9};
        System.out.println(new _045_把数组排成最小的数().minNumber(nums));
    }
    /**
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
     *
     * 想法：越小的数字在前面，组成的数字越小
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] data = new String[nums.length]; //创建一个字符串数组
        for(int i = 0; i < nums.length; i ++){
            data[i] = String.valueOf(nums[i]);
        }
        sort(data, 0, data.length - 1);
        StringBuilder sb = new StringBuilder();
        for(String str : data){
            sb.append(str);
        }
        return sb.toString();
    }
    void sort(String[] data, int l, int r){
        if(l >= r)
            return;
        int i = l, j = r;
        String tmp = data[i];
        while(i < j){
            while((data[j] + data[l]).compareTo(data[l] + data[j]) >=0 && i < j) j --;
            while((data[i] + data[l]).compareTo(data[l] = data[i]) <= 0 && i < j) i ++;
            tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }
        data[i] = data[l];
        data[l] = tmp;
        sort(data, l , i - 1);
        sort(data, i + 1, r);
    }
}
