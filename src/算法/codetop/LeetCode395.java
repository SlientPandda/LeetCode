package 算法.codetop;/**
 *
 */

import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName LeetCode395
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/8/3 16:13
 *@Version 1.0
 **/
public class LeetCode395 {
    public int longestSubstring(String s, int k) {
        //time O(N*26*26)   space O(26*26)
        //如果长度小于k 直接返回0
        if (s.length() < k) return 0;
        HashMap<Character, Integer> counter = new HashMap();
        //遍历字符串 将字符串各位字符以及出现次数存在hashmap中
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        //对各字符进行遍历
        for (char c : counter.keySet()) {
            //取小于k个的字符（因符合题意的子字符串必不包含该字符）进行字符串分割
            if (counter.get(c) < k) {
                int res = 0;
                for (String t : s.split(String.valueOf(c))) {
                    //递归分割后的子串，比较符合条件的子串中最大的长度
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        return s.length();
    }


}
