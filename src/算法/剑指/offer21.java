package 算法.剑指;/**
 *
 */

/**
 *@ClassName offer21
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/7/20 14:51
 *@Version 1.0
 **/
public class offer21 {
    //首尾双指针法 time O(N) space O(1)
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            while(i<j && (nums[i]&1) == 1) i++;
            while(i<j && (nums[j]&1) == 0) j--;
            tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
        return nums;
    }
}

