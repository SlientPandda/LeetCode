package algorithm.string;/**
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *@ClassName LeetCode244
 *@Description 最短单词距离II
 *@Author wuhao51
 *@Date 2024/8/7 16:29
 *@Version 1.0
 **/
public class LeetCode244 {
    /**
     * 请设计一个类，使该类的构造函数能够接收一个单词列表。然后再实现一个方法，该方法能够分别接收两个单词 word1 和 word2，
     * 并返回列表中这两个单词之间的最短距离。您的方法将被以不同的参数调用多次。
     *
     * 示例:
     * 假设 words = ["practice", "makes", "perfect", "coding", "makes"]
     *
     * 输入: word1 = “coding”, word2 = “practice”
     * 输出: 3
     * 输入: word1 = "makes", word2 = "coding"
     * 输出: 1
     */

    HashMap<String, List<Integer>> map;

    public LeetCode244(String[] words) {
        this.map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> idxList = null;
            if (map.get(words[i]) == null) {
                idxList = new ArrayList<>();
            } else {
                idxList = map.get(words[i]);
            }
            idxList.add(i);
            map.put(words[i], idxList);
        }
    }

    /**
     * 用户访问时先通过两个字符串得到对应的下标列表，然后遍历下标列表得到最短距离
     * 此题关键是给出的字符串数组中字符串可能重复，所以需要寻找到最短的距离
     * @return
     */
    public int theShortestDistance(String word1, String word2) {
        List<Integer> idx1List = map.get(word1);
        List<Integer> idx2List = map.get(word2);
        int i = 0, j = 0, distance = Integer.MAX_VALUE;
        // 比较得出最短距离，丢弃掉较小的一方来逼近最短距离
        while (i < idx1List.size() && j < idx2List.size()) {
            distance = Math.min(Math.abs(idx1List.get(i) - idx2List.get(j)), distance);
            if (idx1List.get(i) < idx2List.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return distance;
    }
}
