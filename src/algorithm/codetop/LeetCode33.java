package algorithm.codetop;
/**
 *
 */

/**
 *@ClassName LeetCode33
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/9/11 13:53
 *@Version 1.0
 **/
public class LeetCode33 {
    // 1、有序数组可以利用左右两端大小判断target是否在范围内。
    // 2、每次一分为二都会有有序数组和无序数组。
    // 3、有序数组的左右端点有序，乱序一定无序
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            //找到有序数组，利用有序性判断是否在有序数组内，如果不在则判断另外半区。
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
