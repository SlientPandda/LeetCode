package 算法.codetop;/**
 *
 */

import 算法.DataStructure.TreeNode;

/**
 *@ClassName LeetCode112
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/11 10:54
 *@Version 1.0
 **/
public class LeetCode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return recur(root, targetSum);
    }

    //不要累加判断是否等于目标和，这样有范围问题，可以直接使用递减，初始为目标和，然后每次减去遍历的值
    private boolean recur(TreeNode root, int count) {
        if (root == null) return false;
        if (count == 0 && root.left == null && root.right == null) return true;
        count -= root.val;
        return recur(root.left, count) || recur(root.right, count);
    }

}
