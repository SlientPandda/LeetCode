package algorithm.codetop;/**
 *
 */

/**
 *@ClassName LeetCode11
 *@Description 盛最多水的容器
 *@Author wuhao51
 *@Date 2023/8/29 10:15
 *@Version 1.0
 **/
public class LeetCode11 {
    //双指针法，时间复杂度O(N)，空间复杂度O(1)
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = Integer.MIN_VALUE;
        while (i < j) {
            res = Math.max((j - i) * Math.min(height[i], height[j]), res);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
