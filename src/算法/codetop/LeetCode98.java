package 算法.codetop;/**
 *
 */

import 算法.DataStructure.TreeNode;

/**
 *@ClassName LeetCode98
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/7 20:18
 *@Version 1.0
 **/
public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        return recur(root);
    }

    private boolean recur(TreeNode root) {
        if(root == null) return true;
        if(root.left != null && root.val < root.left || root.right != null && )
    }
}
