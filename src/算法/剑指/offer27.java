package 算法.剑指;/**
 *
 */

import 算法.DataStructure.TreeNode;

/**
 *@ClassName offer27
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/7/22 15:57
 *@Version 1.0
 **/
public class offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}
