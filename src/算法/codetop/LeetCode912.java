package 算法.codetop;/**
 *
 */

import java.util.Arrays;
import java.util.Random;

/**
 *@ClassName LeetCode912
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/8/16 19:48
 *@Version 1.0
 **/
public class LeetCode912 {
    //time O(NlogN) space O(logN)
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    //快排
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition2(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    //切分第一版
    public int partition1(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left + 1;
        // nums[left+1 ...j] <= pivot
        // nums[j..i] > pivot
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, j, i);
                j++;
            }
        }
        swap(nums, j - 1, left);
        return j - 1;
    }

    //切分第二版 解决递归树问题和重复元素问题 使用随机选择切分元素和双指针快排的方式
    public int partition2(int[] nums, int left, int right) {
        int len = right - left + 1;
        int randomIndex = left + RANDOM.nextInt(len);
        swap(nums, randomIndex, left);
        int pivot = nums[left];
        int le = left + 1, ge = right;
        // nums[left... le) <= pivot
        // nums(ge..right] >= pivot
        while (true) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }
            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }
            //交换第一个不小于pivot的nums[le]和第一个不大于pivot的nums[ge]
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

    public void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index2];
        nums[index2] = nums[index1];
        nums[index1] = tmp;
    }


}
