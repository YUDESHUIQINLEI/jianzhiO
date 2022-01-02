package 数组;

public class _004_寻找两个正序数组的中位数 {
    public static void main(String[] args){
        int[] nums1 = {1, 2};
        int[] nums2 = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        System.out.println(new _004_寻找两个正序数组的中位数().findMedianSortedArrays(nums1, nums2));
    }
    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     *
     * 想法：
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); //要长的数组在后面
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            // 数组的前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 数组的后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;  //中位数
//            System.out.print(i + " "+j);
//            System.out.println();

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            System.out.print("nums_im1: " + nums_im1 + "  ");
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            System.out.print("nums_i: " + nums_i + "  ");
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            System.out.print("nums_jm1: " + nums_jm1 + "  ");
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);
            System.out.print("nums_j: " + nums_j + "  ");

            if (nums_im1 < nums_j) {
                median1 = Math.max(nums_im1, nums_jm1); //左面队列的最小值
                median2 = Math.min(nums_i, nums_j); //右面队列的最大值
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }
}
