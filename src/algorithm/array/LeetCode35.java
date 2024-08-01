package algorithm.array;/**
 *
 */

/**
 *@ClassName LeetCode35
 *@Description 搜索插入位置 等价于实现二分查找
 *@Author wuhao51
 *@Date 2024/8/1 20:11
 *@Version 1.0
 **/
public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        // 左右区间边界
        int i = 0, j = nums.length - 1;
        int mid = 0;
        while (i <= j) {
            mid = i + (j - i) / 2;
            if (nums[mid] == target) return mid;
            // 如果查询值比目标值大，说明目标值在中点左边区间内
            if (nums[mid] > target) j = mid - 1;
            // 反之说明在中点右边区间内
            else i = mid + 1;
        }
        // 此时 i 都大于 j，说明 target在（j， i）区间内 直接取i即为待插入位置
        return i;
    }
}
