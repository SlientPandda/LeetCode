package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.TreeNode;

/**
 *@ClassName LeetCode700
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/7 17:47
 *@Version 1.0
 **/
public class LeetCode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        return iterate(root, val);
    }

    private TreeNode iterate(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) return root;
            if (root.val < val) root = root.right;
            else root = root.left;
        }
        return null;
    }

    private TreeNode recur(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val < val) return recur(root.right, val);
        if (root.val > val) return recur(root.left, val);
        return root;
    }


}
