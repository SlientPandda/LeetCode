package 算法.codetop;/**
 *
 */

import 算法.DataStructure.TreeNode;

/**
 *@ClassName LeetCode404
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/2 11:03
 *@Version 1.0
 **/
public class LeetCode404 {
    private int res;

    public int sumOfLeftLeaves(TreeNode root) {
        recur(root);
        return res;
    }

    private void recur(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.left.left == null && root.left.right == null) res += root.left.val;
        recur(root.left);
        recur(root.right);
    }


}
