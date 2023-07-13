package algorithm.codetop;/**
 *
 */

import java.util.*;

/**
 *@ClassName LeetCode15
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/8/11 19:39
 *@Version 1.0
 **/
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //time O(N^2) space O(1)
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for (int k = 0; k < len - 2; k++) {
            //升序排列 首元素大于0 三者之和不可能为0 直接跳出循环
            if (nums[k] > 0) break;
            //如果首元素与前次循环的值相同 则为了去重而跳过
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = len - 1;
            while (i < j) {
                int target = nums[k] + nums[i] + nums[j];
                if (target == 0) {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    //两个指针的元素也要去重
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
                if (target < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                }
                if (target > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return res;
    }
}
