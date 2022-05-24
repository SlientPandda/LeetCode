package 算法.二分;/**
 *
 */

/**
 *@ClassName LeetCode153
 *@Description 153. 寻找旋转排序数组中的最小值
 *@Author wuhao51
 *@Date 2022/5/20 13:47
 *@Version 1.0
 **/
public class LeetCode153 {
    public int findMin(int[] nums) {
        //时间复杂度O(logN) 空间复杂度O(1)
        //排序数组的查找问题首先考虑使用 二分法 解决，其可将 遍历法 的 线性级别 时间复杂度降低至 对数级别 。
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = (low + high) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot; //如果中点是最小值点，并且由于数组内无重复数字，那么一定满足小于右边界的值，右边界缩小到中点不会越过最小值
            } else {
                low = pivot + 1; //如果先满足中点值等于或大于右边界值，则中点值一定在最小值左边，不可能等于最小值
            }
        }
        return nums[low];
    }
}
