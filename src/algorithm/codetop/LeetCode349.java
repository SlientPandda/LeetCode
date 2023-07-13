package algorithm.codetop;/**
 *
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 *@ClassName LeetCode349
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/1/9 11:30
 *@Version 1.0
 **/
public class LeetCode349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numsSet = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums1) {
            numsSet.add(num);
        }
        for (int num : nums2) {
            if (numsSet.contains(num)) {
                resultSet.add(num);
            }
        }
        return resultSet.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4,5,6,7};
        int[] nums2 = new int[]{3,4,5,6,7,8,9,10};
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        System.out.println(Arrays.toString(Arrays.stream(nums2).distinct().filter(set::contains).toArray()));
    }
}
