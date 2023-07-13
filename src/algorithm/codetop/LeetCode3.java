package algorithm.codetop;/**
 *
 */

import java.util.*;

/**
 *@ClassName LeetCode3
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/8/2 15:49
 *@Version 1.0
 **/
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        // time O(N) space O(N)
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            length = Math.max(length, i - left + 1);
        }
        return length;
    }
}
