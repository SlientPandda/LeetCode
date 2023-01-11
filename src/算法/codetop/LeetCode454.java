package 算法.codetop;/**
 *
 */

import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName LeetCode454
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/1/10 17:35
 *@Version 1.0
 **/
public class LeetCode454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int count = 0;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                numMap.put(num1 + num2, numMap.getOrDefault(num1 + num2, 0) + 1);
            }
        }
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                if (numMap.containsKey(-num3 - num4)) {
                    count += numMap.get(-num3 - num4);
                }
            }
        }
        return count;
    }
}
