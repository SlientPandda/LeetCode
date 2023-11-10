package algorithm.codetop;/**
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *@ClassName LeetCode46
 *@Description 全排列
 *@Author wuhao51
 *@Date 2023/11/10 11:05
 *@Version 1.0
 **/
public class LeetCode46 {
    List<List<Integer>> res;
    List<Integer> output;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backTrack(n, res, output, 0);
        return res;
    }

    /**
     * 回溯法，根据数组排列的特点，考虑深度优先搜索所有排列方案。
     * 即通过元素交换，先固定第 1 位元素（ n 种情况）、再固定第 2 位元素（ n−1 种情况）、... 、最后固定第 n位元素（ 1种情况）。
     * 以first为分界，小于first下标为已固定数组，大于等于first下标为待填入数组，当数组长度达到最大长度时，作为一个排列加入结果列表中。
     * @param n
     * @param res
     * @param output
     * @param first 当前数组中需要填入元素的位置
     */
    private void backTrack(int n, List<List<Integer>> res, List<Integer> output, int first) {
        if (first == n) {
            //一定要记得重新创建一个列表，否则使用的是一个地址
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backTrack(n, res, output, first + 1);
            Collections.swap(output, first, i);
        }
    }
}
