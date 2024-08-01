package algorithm.string;/**
 *
 */

import java.util.*;

/**
 *@ClassName LeetCode3
 *@Description 无重复字符的最长子串
 *@Author wuhao51
 *@Date 2022/8/2 15:49
 *@Version 1.0
 **/
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        // time O(N) space O(N)
        // 此map缓存字符与其上一次出现的位置
        Map<Character, Integer> map = new HashMap<>();
        // 不重复子串的左边界，最大长度
        int left = 0, length = 0;
        // 遍历当前字符串
        for (int i = 0; i < s.length(); i++) {
            // 如果这个字符已经在 map 中（即存在重复字符），
            // 更新 left 的值为 Math.max(left, map.get(s.charAt(i)) + 1)。
            // 这一步是为了确保窗口左侧的起始位置在重复字符的右侧，从而保证窗口内没有重复字符。
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // 当前字符位置到map中
            map.put(s.charAt(i), i);
            // 计算当前滑动窗口长度
            length = Math.max(length, i - left + 1);
        }
        return length;
    }
}
