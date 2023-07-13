package algorithm.sword;/**
 *
 */

import algorithm.datastructure.TreeNode;

/**
 *@ClassName offer27
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/7/22 15:57
 *@Version 1.0
 **/
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}
