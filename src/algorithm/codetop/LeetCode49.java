package algorithm.codetop;/**
 *
 */

import java.util.*;

/**
 *@ClassName LeetCode49
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/11/17 10:09
 *@Version 1.0
 **/
public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //排序，时间复杂度O（nklogk）k是strs中字符串最大长度，需要遍历n个字符串。空间复杂度O（nk）
        //字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
        //如果一个字符串是另一个字符串的字母异位词，那么这两个字符串都按字典序排序后一定是相同的字符串。
        //那么可以使用哈希表的方法，将排序后的字符串作为key值，同一个字典序的字符串列表作为value值。最后将哈希表的values返回。
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> subList = map.getOrDefault(key, new ArrayList<>());
            subList.add(s);
            map.put(key, subList);
        }
        return new ArrayList<>(map.values());
    }
}
