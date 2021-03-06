package 算法.剑指;/**
 *
 */

import 算法.DataStructure.TreeNode;

/**
 *@ClassName offer28
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/7/22 17:49
 *@Version 1.0
 **/
public class offer28 {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }
    public boolean recur(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null || l.val != r.val) return false;
        return recur(l.left, r.right) && recur(l.right, r.left);
    }
}
