package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.TreeNode;

/**
 *@ClassName LeetCode538
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/22 20:07
 *@Version 1.0
 **/
public class LeetCode538 {
    private int sum;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        recur(root);
        return root;
    }

    private void recur(TreeNode root) {
        if (root == null) return;
        recur(root.right);
        sum += root.val;
        root.val = sum;
        recur(root.left);
    }

}
