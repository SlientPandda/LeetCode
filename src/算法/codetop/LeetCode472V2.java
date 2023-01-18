package 算法.codetop;/**
 *
 */

import 算法.DataStructure.TrieNode;

import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName LeetCode472V2
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/1/17 14:14
 *@Version 1.0
 **/
public class LeetCode472V2 {
    private List<String> res = new ArrayList<>();
    private TrieNode dict = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for (String s : words) {
            dict.insert(s);
        }
        for (String s : words) {
            if (isConcatenatedWords(s, 0, 0)) {
                res.add(s);
            }
        }
        return res;
    }

    private Boolean isConcatenatedWords(String s, int count, int start) {
        if (start >= s.length() && count > 1) return true;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (dict.search(sb.toString()) && isConcatenatedWords(s, count + 1, i + 1)) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(findAllConcatenatedWordsInADict(new String[]{
                "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"
        }));
    }
}
