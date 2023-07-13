package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.TreeNode;

/**
 *@ClassName LeetCode701
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/20 19:27
 *@Version 1.0
 **/
public class LeetCode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode node = root;
        TreeNode pre = root;
        while (root != null) {
            pre = root;
            if (root.val > val) root = root.left;
            else root = root.right;
        }
        if (pre.val > val) pre.left = new TreeNode(val);
        else pre.right = new TreeNode(val);
        return node;
    }
}
