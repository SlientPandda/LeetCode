package 算法.codetop;/**
 *
 */

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;
import java.util.Random;

/**
 *@ClassName LeetCode215
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/8/8 19:39
 *@Version 1.0
 **/
public class LeetCode215 {

    private final static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        //双路快排实现有序
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums[len - k];
    }

    //快排递归函数
    private void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    //返回每一轮确定的pivot值对应的数组下标
    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);

        int pivot = nums[left];

        int le = left + 1;
        int ge = right;

        while (true) {
            while (le <= ge && pivot > nums[le]) {
                le++;
            }
            while (le <= ge && pivot < nums[ge]) {
                ge--;
            }
            // le 来到了第一个大于等于 pivot 的位置
            // ge 来到了第一个小于等于 pivot 的位置
            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }
        swap(nums, left, ge);
        return ge;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
