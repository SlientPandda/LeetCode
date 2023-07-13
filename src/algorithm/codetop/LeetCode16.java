package algorithm.codetop;/**
 *
 */

import java.util.Arrays;

/**
 *@ClassName LeetCode16
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/8/12 11:34
 *@Version 1.0
 **/
public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        //space O(1) time O(N^2)
        Arrays.sort(nums);
        int len = nums.length, ans = Integer.MAX_VALUE;
        for (int k = 0; k < len - 2; k++) {
            int i = k + 1, j = len - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum > target) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else if (sum < target) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }

}
