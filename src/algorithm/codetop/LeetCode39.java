package algorithm.codetop;/**
 *
 */

import java.util.*;

/**
 *@ClassName LeetCode39
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/9/12 13:44
 *@Version 1.0
 **/
public class LeetCode39 {
    //时间复杂度：O（S），S为所有可行解的长度之和。 空间复杂度：O（N）递归栈深度
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //求所有组合问题，想到回溯
        List<List<Integer>> resList = new ArrayList<>();
        recur(resList, candidates, target, new ArrayList<>(), 0);
        return resList;
    }

    private void recur(List<List<Integer>> resList, int[] candidates, int target, List<Integer> subResList, int index) {
        if (target == 0) {
            //直接添加子列表，由于是引用对象，所以后面remove的时候会操作添加后的子列表，
            resList.add(new ArrayList<>(subResList));
            return;
        }
        if (index == candidates.length) return;
        //直接跳过该数字
        recur(resList, candidates, target, subResList, index + 1);
        //或者添加当前数字
        if (target - candidates[index] >= 0) {
            subResList.add(candidates[index]);
            recur(resList, candidates, target - candidates[index], subResList, index);
            subResList.remove(subResList.size() - 1);
        }
    }
}
