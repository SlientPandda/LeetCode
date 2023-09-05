package algorithm.codetop;/**
 *
 */

import java.util.Arrays;

/**
 *@ClassName LeetCode31
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/9/5 10:02
 *@Version 1.0
 **/
public class LeetCode31 {
    //例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
    //类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
    //而arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
    //给你一个整数数组 nums ，找出 nums 的下一个排列。
    //必须原地修改，只允许使用额外常数空间。
    //1 <= nums.length <= 100
    //0 <= nums[i] <= 100

    //需要高位不变修改低位，所以需要从后往前考虑。
    //如果全降序（4-3-2-1），那么是无法找到更大的数，所以需要反转数组即可。所以只有从后往前找到第一个升序的位置，与后面交换才有可能变大（1*-4-3-2）。
    //当我们想要让整个数字变大，但是又变大的幅度足够小，则需要找到后置位中比它大的数字中最小的那个，交换两者即可。
    //最后为了使整体数字够小还需要使后置位变为升序，由于交换后不影响整体大小关系，直接逆序即可。
    //时间复杂度：O(N) 空间复杂度：O(1)
    public void nextPermutation(int[] nums) {
        int k = nums.length - 1;
        while (k > 0 && nums[k - 1] >= nums[k]) k--;
        if (k == 0) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int t = nums.length - 1;
            while (nums[t] <= nums[k - 1]) t--;
            swap(nums, t, k - 1);
            reverse(nums, k, nums.length - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
