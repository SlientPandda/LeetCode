package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.TreeNode;

/**
 *@ClassName LeetCode226
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/10 9:47
 *@Version 1.0
 **/
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        recur(root);
        return root;
    }

    private void recur(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        recur(root.left);
        recur(root.right);
    }


}
