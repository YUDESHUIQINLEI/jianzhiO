package 栈和队列;
import java.util.*;
public class _084_柱状图中最大的矩形 {
    public static void main(String[] args){
        _084_柱状图中最大的矩形 solution = new _084_柱状图中最大的矩形();
        int[] heights = {2,1,5,6,2,3};
        System.out.print(solution.largestRectangleArea(heights));
    }
    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     *
     * 想法：遇到后面的节点值小于当前节点的 当前节点的高度 *（现在的下标 - 栈中前面节点的下标值）
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int res = 0;
        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;
        for(int hieght : heights){
            System.out.print(hieght + " ");
        }
        System.out.println();
        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);
        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                System.out.print(stack.peekLast() + "--" + heights[stack.peekLast()] + "  ");
                int curHeight = heights[stack.pollLast()];
                System.out.print(stack.peekLast() + "--" + heights[stack.peekLast()] + "  ");
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
                System.out.println();
            }
            stack.addLast(i);
        }
        return res;
    }
}