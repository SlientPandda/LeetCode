package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName LeetCode113
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/13 9:56
 *@Version 1.0
 **/
public class LeetCode113 {
    private List<List<Integer>> resList;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        resList = new ArrayList<>();
        recur(root, targetSum, new ArrayList<>());
        return resList;
    }

    //全路径不需要有返回值，需要回溯去除已添加的节点
    private void recur(TreeNode root, int count, ArrayList<Integer> objects) {
        if (root == null) return;
        objects.add(root.val);
        if (root.left == null && root.right == null && count == root.val) {
            resList.add(new ArrayList<>(objects));
            return;
        }
        if (root.left != null) {
            recur(root.left, count - root.val, objects);
            //回溯
            objects.remove(objects.size() - 1);
        }
        if (root.right != null) {
            recur(root.right, count - root.val, objects);
            objects.remove(objects.size() - 1);
        }
    }

}
