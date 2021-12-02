package 数组;
import java.util.*;
public class _056_合并区间 {
    public static void main(String[] args){
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] res = new _056_合并区间().merge(intervals);
        for(int i = 0; i < res.length; i ++){
            for(int j = 0; j < 2; j ++){
                System.out.print(res[i][j] + " ");
            }
        }
    }

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，
     * 并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     *
     * 想法：需要数组是保持按照左边界递增的数组，然后进行比较；如果前一个数组的右边界大等于后一个数组的左边界，就要合并在一起；
     * 合并的时候要注意，合并后的右边界需要是max(上一个数组的右边界，遍历到的这个数组的右边界)
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if(intervals == null)
            return new int[0][1];
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });//按照左面的数字做升序
        for(int i = 0; i < intervals.length; i ++){
            int left = intervals[i][0], right = intervals[i][1];
            if(res.size() == 0 || (res.get(res.size() - 1)[1] < left)){
                res.add(new int[]{left, right});
                System.out.println(left + " 我是上面的判断条件" + right);
            }else{
                //得到之后 还能够再赋值 这个得记住
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], right);
                System.out.println(left + " 我是下面的判断条件" + right);
            }
        }
        System.out.println(res.size());
        for(int i = 0; i < res.size(); i ++){
            System.out.println(res.get(i)[0] + "  " + res.get(i)[1]);
        }
        System.out.println();
        return res.toArray(new int[res.size()][]);
    }
}
