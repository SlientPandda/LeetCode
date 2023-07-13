package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *@ClassName LeetCode107
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/6 17:36
 *@Version 1.0
 **/
public class LeetCode107 {
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        recur(root, 0);
        Collections.reverse(resList);
        return resList;
    }

    /**
     * 递归打印出层序的节点值
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param root
     * @param deep
     */
    public void recur(TreeNode root, int deep) {
        if (root == null) return;
        deep++;
        //如果reslist大小小于当前深度，说明第一次进入该层，则new一个空列表，加入结果列表
        if (resList.size() < deep) {
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        //获取当前深度的对应列表，将当前节点值加入列表
        resList.get(deep - 1).add(root.val);
        //递归左右节点
        recur(root.left, deep);
        recur(root.right, deep);
    }
}
