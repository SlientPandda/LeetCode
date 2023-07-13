package algorithm.codetop;/**
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@ClassName LeetCode347V2
 *@Description 347的桶排序实现
 *@Author wuhao51
 *@Date 2023/2/6 9:53
 *@Version 1.0
 **/
public class LeetCode347V2 {
    //思路：创建一个频率数组
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequent = new HashMap<>();//存储频率与数字的hashmap
        for (int num : nums) {
            frequent.put(num, frequent.getOrDefault(num, 0) + 1);//频率累加 key是数组中的数组 value是频率

        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequent.keySet()) {
            int frequency = frequent.get(key);
            if (buckets[frequency] == null)
                buckets[frequency] = new ArrayList<>();
            buckets[frequency].add(key);
        }
        //按频率为下标把对应的数字存储在array list数组中
        List<Integer> topk = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topk.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            } else if (buckets[i].size() <= k - topk.size()) {
                topk.addAll(buckets[i]);
            } else {
                topk.addAll(buckets[i].subList(0, k - topk.size()));
            }
        }
        //从桶中从高到低把频率高低的topk个数取出放入topk数组中
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topk.get(i);
        }
        return result;
    }
}
