package 算法.codetop;/**
 *
 */

import java.util.Arrays;

/**
 *@ClassName LeetCode27
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/10/11 20:16
 *@Version 1.0
 **/
public class LeetCode27 {
    public static int removeElement(int[] nums, int val) {
        //相向双指针法
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            // 找左边等于val的元素
            //如果左右index重合在一点时，也保证了能对这点进行判断
            while (leftIndex <= rightIndex && nums[leftIndex] != val) {
                leftIndex++;
            }
            // 找右边不等于val的元素
            while (leftIndex <= rightIndex && nums[rightIndex] == val) {
                rightIndex--;
            }
            // 将右边不等于val的元素覆盖左边等于val的元素
            if (leftIndex < rightIndex) {
                nums[leftIndex++] = nums[rightIndex--];
            }
        }
        return leftIndex;   // leftIndex一定指向了最终数组末尾的下
        //双指针法
//        int j = nums.length - 1; //新数组的长度
//        for (int i = 0; i <= j; i++) {
//            if (nums[i] == val) {
//                swap(nums, i--, j--);
//            }
//        }
//        return j + 1;
        //快慢指针法
//        int index = 0;
//        for (int num : nums) {
//            if (num != val) nums[index++] = num;
//        }
//        return index;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1}, 1));
    }
}
