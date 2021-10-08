package 搜索算法;

public class _011_旋转数组的最小数字 {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     *
     * 想法：顺序查找，出现的第一个元素大于后一个元素的，就是旋转的节点；如果一直找不到，就代表这个数组没有旋转，就返回数组的第一个元素；
     * 时间复杂度：O（n） 如果数组大的话 时间复杂度就比较高的
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if(numbers.length == 0)
            return -1;
        for(int i = 0; i < numbers.length - 1; i ++){
            if(numbers[i] > numbers[i + 1])
                return numbers[i + 1];
        }
        return numbers[0];
    }

    /**
     * 通过二分查找法，这个二分查找需要注意的是要从后向前找，因为有可能没有旋转，所以要和数组的尾部进行比较，要是小的话，把队尾设置为mid，大的话，i=mid+1, 逐步缩小取值范围
     * @param numbers
     * @return
     */
    public int minArray1(int[] numbers){
        if(numbers.length == 0)
            return -1;
        int i = 0, j = numbers.length - 1;
        while(i < j){
            int mid = (j + i) / 2;
            if(numbers[mid] > numbers[j])
                i = mid + 1;
            else if(numbers[mid] < numbers[j])
                j = mid;
            else
                j --;
        }
        return numbers[i];
    }
}
