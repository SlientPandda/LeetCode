package 算法.codetop;/**
 *
 */

import java.util.*;

/**
 *@ClassName LeetCode347
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/3 14:42
 *@Version 1.0
 * 时间复杂度：O(NlogK)
 * 空间复杂度：O(N)
 **/
public class LeetCode347 {
    /**
     * 1、统计元素出现频率
     * 2、对频率进行排序
     * 3、找出前k个高频元素
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        //key-num,value-frequency
        HashMap<Integer, Integer> freMap = new HashMap<>();
        for (int num : nums) {
            freMap.put(num, freMap.getOrDefault(num, 0) + 1);
        }
        //使用优先队列，对频率进行排序，底层原理是大顶堆、小顶堆
        //comparator:返回负数，参数一排前面；返回正数，参数二排前面
        //使用大小为k的小顶堆来实现，小元素弹出，遍历完成后留下前k个最大元素
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        for (Map.Entry<Integer, Integer> entry : freMap.entrySet()) {
            if (pq.size() < k) {
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            } else if (entry.getValue() > pq.peek()[1]) {
                pq.poll();
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
