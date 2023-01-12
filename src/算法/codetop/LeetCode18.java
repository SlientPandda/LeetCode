package 算法.codetop;/**
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@ClassName LeetCode18
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/1/11 14:12
 *@Version 1.0
 **/
public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            // 剪枝处理
            if (nums[i] > target && nums[i] >= 0) break;
            // 对nums[i]去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 2级剪枝处理
                if (nums[i] + nums[j] > target && nums[i] + nums[j] >= 0) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[++left]) ;
                        while (left < right && nums[right] == nums[--right]) ;
                    } else if (sum < target) {
                        while (left < right && nums[left] == nums[++left]) ;
                    } else {
                        while (left < right && nums[right] == nums[--right]) ;
                    }
                }
            }
        }
        return res;
    }
}
