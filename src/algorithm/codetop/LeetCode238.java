package algorithm.codetop;/**
 *
 */

import java.util.Arrays;
import java.util.Map;

/**
 *@ClassName LeetCode238
 *@Description TODO
 *@Author wuhao51
 *@Date 2024/5/28 19:48
 *@Version 1.0
 **/
public class LeetCode238 {
    /**
     * 左右乘积列表
     * 时间复杂度：O（N）
     * 空间复杂度：O（N）
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        // 左乘积*右乘积
        int[] lnums = new int[nums.length];
        int[] rnums = new int[nums.length];
        lnums[0] = 1;
        rnums[rnums.length - 1] = 1;

        // 两次扫描
        for (int i = 1; i < nums.length; i++) {
            lnums[i] = lnums[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            rnums[i] = rnums[i + 1] * nums[i + 1];
        }

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = lnums[i] * rnums[i];
        }
        return res;
    }
}
