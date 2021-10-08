package 搜索算法;

public class _004_二维数组中的查找 {
    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * 其实就是从最后一列的第一行找，若目标值小于该值，抛去最后一列，若目标值大于该值，抛去第一行，以此类推，逐步缩小定位区域
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        int m = matrix.length; //优先取得是行的个数
        int n  = matrix[0].length - 1; //列数
        int i = 0;
        while(i < m && n >= 0){
            if(matrix[i][n] > target)
                -- n;
            else if(matrix[i][n] < target)
                i ++;
            else
                return true;
        }
        return false;
    }
}
