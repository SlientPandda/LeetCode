package algorithm.codetop;/**
 *
 */

import java.util.ArrayDeque;

/**
 *@ClassName LeetCode84
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/16 14:23
 *@Version 1.0
 **/
public class LeetCode84 {
    public int largestRectangleArea(int[] heights) {
        return recur(0, heights.length - 1, heights);
    }

    //递归算法，先求出当前最矮的矩形面积，然后左右递归计算，比较最大面积,93/98
    //时间复杂度，O(N^2)
    //空间复杂度，O(log2(n+1)*n)
    private Integer recur(int start, int end, int[] heights) {
        if (start > end) return 0;
        int minIndex = start;
        for (int i = start; i <= end; i++) {
            if (heights[i] < heights[minIndex]) minIndex = i;
        }
        int res = heights[minIndex] * (end - start + 1);
        return Math.max(res, Math.max(recur(start, minIndex - 1, heights), recur(minIndex + 1, end, heights)));
    }

    //单调栈算法
    //时间复杂度，一次遍历：O(N)
    //空间复杂度，O(N)
    private Integer monotonicStacks(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];
        //存放数组元素下标的单调栈，栈底最小
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //结果值，最大矩形面积
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            //如果当前遍历元素小于栈顶元素则弹出栈顶元素，否则压入栈
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                //当前矩形元素高度值
                int curHeight = heights[stack.pop()];
                //去重元素
                while (!stack.isEmpty() && heights[stack.peek()] == curHeight) {
                    stack.pop();
                }
                //如果当前栈不空，则宽度为当前栈顶值与i距离。如果当前栈为空，则说明当前高度为前i个元素最小值，则长度为i
                int curWidth = stack.isEmpty() ? i : i - stack.peek() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.push(i);
        }
        //处理栈不为空的情况
        while (!stack.isEmpty()) {
            //当前矩形元素高度值
            int curHeight = heights[stack.pop()];
            //去重元素
            while (!stack.isEmpty() && heights[stack.peek()] == curHeight) {
                stack.pop();
            }
            //如果当前栈不空，则宽度为当前栈顶值与末尾的距离。如果当前栈为空，则说明当前高度为数组中最小值，则长度为len
            int curWidth = stack.isEmpty() ? len : len - stack.peek() - 1;
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }

}
