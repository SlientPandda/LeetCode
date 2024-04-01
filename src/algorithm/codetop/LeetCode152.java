package algorithm.codetop;/**
 *
 */

import sun.applet.Main;

import java.util.Arrays;

/**
 *@ClassName LeetCode152
 *@Description TODO
 *@Author wuhao51
 *@Date 2024/4/1 11:35
 *@Version 1.0
 **/
public class LeetCode152 {
    /**
     * 时间复杂度 O（N）
     * 空间复杂度 O（1）
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        // 1、如果当前元素大于0，则乘以
        // 确定dp数组含义： 以i为结尾的连续子数组的乘积最大值。
        // 如果当前位置是负数的话，会考虑以其前一个位置结尾的某个积也是负数，这样整体乘积更大。
        // 如果当前位置是正数的话，会考虑以其前一个位置结尾的某个积是正数，这样相乘之后
        // dp递推公式：max[i] = math.max(max[i-1] * nums[i], nums[i]，min[i-1] * nums[i])
        // min[i] = math.min(min[i-1] * nums[i], nums[i])
        // dp数组初始化
        // 确定遍历顺序
        // 举例推导dp数组

        //我们可以根据正负性进行分类讨论。
        //考虑当前位置如果是一个负数的话，那么我们希望以它前一个位置结尾的某个段的积也是个负数，这样就可以负负得正，并且我们希望这个积尽可能「负得更多」，即尽可能小。
        //如果当前位置是-个正数的话，我们更希望以它前一个位置结尾的某个段的积也是个正数，并且希望它尽可能地大。
        //于是这里我们可以再维护一个fmin(i），它表示以第个元素结尾的乘积最小子数组的乘积，那么我们可以得到这样的动态规划转移方程：
        //fmax(i) := max{fmax(i - 1) x ai, fmin(i - 1) x a, ai}=1fmin(i)min{fmax(i - 1) x ai, fmin(i - 1) x ai, ai}n=1
        //它代表第 个元素结尾的乘积最大子数组的乘积fmax(i)，可以考虑把α加入第－1 个元素结尾的乘积最大或最小的子数组的乘积中，二者加上α，三者取大，就是第个元素结尾的乘积最大子数组的乘积。第个元素结尾的乘积最小子数组的乘积fmin(i)同理。

        int min = nums[0];
        int max = nums[0];
        int ans = max;

        for (int i = 1; i < nums.length; i++) {
            int mx = max, mn = min;
            max = Math.max(mx * nums[i], Math.max(mn * nums[i], nums[i]));
            min = Math.min(mn * nums[i], Math.min(mx * nums[i], nums[i]));
            ans = Math.max(ans, max);
        }

        return ans;
    }
}
