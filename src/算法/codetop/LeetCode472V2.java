package 算法.codetop;/**
 *
 */

import 算法.DataStructure.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *@ClassName LeetCode472V2
 *@Description 自己写的字典树版本
 *@Author wuhao51
 *@Date 2023/1/17 14:14
 *@Version 1.0
 * n为words数组大小，
 * 时间复杂度：O()
 * 空间复杂度：O()
 **/
public class LeetCode472V2 {
    private List<String> res = new ArrayList<>();
    private TrieNode dict = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
//      首先将数组words 按照字符串的长度递增的顺序排序，排序后可以确保当遍历到任意单词时，比该单词短的单词一定都已经遍历过，因此可以根据已经遍历过的全部单词判断当前单词是不是连接词。
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String s : words) {
            if (s.length() == 0) continue;
            //记忆化搜索数组，剪枝
            boolean[] visited = new boolean[s.length()];
            //如果判断是连接词则加入结果集，反之不为连接词则加入字典树
            if (isConcatenatedWords(s, 0, 0, visited)) {
                res.add(s);
            } else {
                dict.insert(s);
            }
        }
        return res;
    }

    private Boolean isConcatenatedWords(String s, int count, int start, boolean[] visited) {
        if (start >= s.length() && count > 1) return true;
        if (visited[start]) return false;
        visited[start] = true;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (dict.search(sb.toString()) && isConcatenatedWords(s, count + 1, i + 1, visited)) return true;
        }
        return false;
    }
}
