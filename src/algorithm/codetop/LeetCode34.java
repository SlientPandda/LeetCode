package algorithm.codetop;/**
 *
 */

/**
 *@ClassName LeetCode34
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/23 20:10
 *@Version 1.0
 **/
public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        int leftBorder = binarySearch(nums, target, true);
        int rightBorder = binarySearch(nums, target, false);
        return new int[]{leftBorder, rightBorder};
    }


    // 二分查找 log(N)
    // flag: true - lower,flase - higher
    private int binarySearch(int[] nums, int target, boolean flag) {
        int border = -1;
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int index = 0;
        while (leftIndex <= rightIndex) {
            index = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[index] < target) {
                leftIndex = index + 1;
            } else if (nums[index] > target) {
                rightIndex = index - 1;
            } else {
                if (flag) {
                    rightIndex = index - 1;
                } else {
                    leftIndex = index + 1;
                }
                border = index;
            }
        }
        return border;
    }

}
