package 算法.二分;/**
 *
 */

/**
 *@ClassName LeetCode704
 *@Description 704. 二分查找
 *@Author wuhao51
 *@Date 2022/3/18 17:13
 *@Version 1.0
 **/
public class LeetCode704 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r +1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            }
            else {
                r = mid - 1;
            }
        }
        return nums[r] == target ? r : -1;
    }

}
