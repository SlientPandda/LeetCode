package 算法.剑指;/**
 *
 */

/**
 *@ClassName offer11
 *@Description 算法.剑指 Offer 11. 旋转数组的最小数字
 *@Author wuhao51
 *@Date 2022/5/17 11:25
 *@Version 1.0
 **/
public class offer11 {
    public int minArray(int[] numbers) {
        // 时间复杂度O(N) 空间复杂度O(1)
//        for (int i = numbers.length - 1; i > 0; i--) {
//            if (numbers[i] < numbers[i - 1]) return numbers[i];
//        }
//        return numbers[0];
        //二分法 时间复杂度O(logN) 空间复杂度 O(1) 最坏情况下 数组中都是重复元素，则每次都要右边界左移，则此时时间复杂度为O(N)
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];

    }
}
