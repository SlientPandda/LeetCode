package algorithm.codetop;/**
 *
 */

import jdk.nashorn.internal.objects.NativeUint8Array;

import java.util.Arrays;

/**
 *@ClassName LeetCode283
 *@Description TODO
 *@Author wuhao51
 *@Date 2024/6/4 9:34
 *@Version 1.0
 **/
public class LeetCode283 {
    public static void moveZeroes(int[] nums) {
        // 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
        // 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移，
        // 注意到以下性质：1.左指针左边均为非零数;2.右指针左边直到左指针处均为零。
        // 因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。
        int left = 0, right = 0;
        while (right < nums.length){
            if (nums[right] != 0){
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
