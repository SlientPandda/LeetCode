package 剑指;/**
 *
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *@ClassName offer03
 *@Description 数组中重复的数字
 *@Author wuhao51
 *@Date 2022/4/13 19:39
 *@Version 1.0
 **/
public class offer03 {
    public int findRepeatNumber(int[] nums) {
        //  第三版 0ms
        int i =0;
        while (i<nums.length){
            if(nums[i]==i){
                i++;
                continue;
            }
            if(nums[nums[i]]==nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i]=nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
//        第二版：Set方法 6ms
//        Set<Integer> set = new HashSet<>();
//        for (int number : nums) {
//            if (set.contains(number)) {
//                return number;
//            }
//            else{
//                set.add(number);
//            }
//        }
//        return 0;
//        第一版：Map方法 7ms
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(map.get(nums[i]) == null){
//                map.put(nums[i], i);
//            }
//            else {
//                return nums[i];
//            }
//        }
//        return 0;
    }
}
