package 其他;

import java.util.LinkedList;
import java.util.List;

public class _057_和为s的正数序列 {
    public static void main(String[] args){
        int target = 9;
        int[][] res = new _057_和为s的正数序列().findContinuousSequence(target);
        System.out.println(res.length + "  " + res[0].length);
    }
    /**
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     *
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     *
     * 两个下标表示滑动窗口的左面和右面，如果窗口内数字和大于target,就要抛弃左面的数字；如果小，就要扩大右面的边界；等于target，就add；当i == j的时候 就证明到达了界限了
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, s = 3;
        List<int[]> res = new LinkedList<>();
        while(i < j){
            if(s == target){
                int[] tmp = new int[j - i + 1];
                for(int k = i; k <= j; k ++){
                    tmp[k - i] = k;
                }
                res.add(tmp);
            }
            if(s >= target){
                s -= i;
                i ++;
            }else{
                j ++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }
}
