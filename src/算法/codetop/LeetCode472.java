package 算法.codetop;/**
 *
 */

import 算法.DataStructure.TrieNode;

import java.util.*;

/**
 *@ClassName LeetCode472
 *@Description hash法的时间复杂度:O(n*m^2) n为数组的长度，m为字符串的长度；空间复杂度：O(n)
 *@Author wuhao51
 *@Date 2023/1/13 17:25
 *@Version 1.0
 **/
public class LeetCode472 {
    private Set<String> dict;
    private List<String> res;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        dict = new HashSet<>();
        res = new ArrayList<>();
        dict.addAll(Arrays.asList(words));
        for (String s : words) {
            if (isContactWords(s, 0, 0)) res.add(s);
        }
        return res;
    }

    //判断当前字符串是否是连接词
    private Boolean isContactWords(String s, int count, int start) {
        //如果起始点比字符串长度长，代表已走完字符串，并且计数大于1，则说明是连接词
        if (start >= s.length() && count > 1) return true;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (dict.contains(sb.toString()) && isContactWords(s, count + 1, i + 1)) return true;
        }
        return false;
    }

}

