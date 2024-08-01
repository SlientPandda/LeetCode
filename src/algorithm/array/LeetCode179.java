package algorithm.array;/**
 *
 */

import java.util.Arrays;

/**
 *@ClassName LeetCode179
 *@Description 最大数
 *@Author wuhao51
 *@Date 2024/7/31 20:04
 *@Version 1.0
 **/
public class LeetCode179 {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        // 把整数数组转换为字符串数组
        for (int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        // 对字符串数组进行排序，排序器是 x+y的字典序大于y+x 此时按正序排列 不过按逆序排列方便输出结果 则按(y + x).compareTo(x + y)进行比较
        Arrays.sort(strs, (x, y) -> (y + x).compareTo(x + y));
        if (strs[0].equals("0"))
            return "0";
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }
}
