package 模拟;/**
 *
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName 1 两数之和
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/3/8 19:55
 *@Version 1.0
 **/
public class LeetCode1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            if (map.containsKey(b)) {
                return new int[]{i, map.get(b)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};

        /**
         * 首先我想到的方法是将数组升序排列，然后再从两头开始查找，结果比目标值大的话，末尾下标往前，反之首部下标往后，直到其和匹配到目标值。
         * 但是题目要求返回是符合要求的两个数组下标，数组排序之后下标变动不符合要求。
         * 题解给出的是空间换时间，拿hashmap存放数组值与下标的KV键值对，先把数组扫描一遍插入到hashmap，然后再做一遍循环，先把扫描的这个元素从集合中删除，
         * （因为怕补数与当前元素相等）
         * 然后再匹配集合中是否存在补数，返回当前元素下标与补数下标。
         * 但是这样做的话，先插入一遍，然后再删除一遍，浪费一些时间。
         * 优化方法是先匹配集合中是否存在补数，如果不存在的话，则将kv键值对put进hashmap中。优化了一些插入删除的时间。
         *
         */
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }
}
