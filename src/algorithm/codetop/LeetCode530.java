package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.TreeNode;

/**
 *@ClassName LeetCode530
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/13 13:53
 *@Version 1.0
 **/
public class LeetCode530 {
    private TreeNode pre;
    private int minNum = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        recur(root);
        return minNum;
    }

    private void recur(TreeNode root) {
        if (root == null) return;
        recur(root.left);
        if (pre != null) minNum = Math.min(minNum, root.val - pre.val);
        pre = root;
        recur(root.right);
    }
}
