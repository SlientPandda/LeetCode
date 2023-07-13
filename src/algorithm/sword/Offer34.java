package algorithm.sword;/**
 *
 */

import algorithm.datastructure.TreeNode;
import algorithm.util.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName Offer34
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/7/13 13:47
 *@Version 1.0
 **/
public class Offer34 {
    //保存全路径的结果集
    private List<List<Integer>> resList;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        resList = new ArrayList<>();
        recursion(root, target, new ArrayList<Integer>());
        return resList;
    }

    private void recursion(TreeNode root, int count, List<Integer> subList) {
        if (root == null) return;
        subList.add(root.val);
        if (root.left == null && root.right == null && root.val == count) {
            resList.add(new ArrayList<>(subList));
        }
        recursion(root.left, count - root.val, subList);
        recursion(root.right, count - root.val, subList);
        subList.remove(subList.size() - 1);
    }


    private int sum(List<Integer> list) {
        return list.stream().mapToInt(s -> s).sum();
    }

}
