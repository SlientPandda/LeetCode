package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.TreeNode;

/**
 *@ClassName LeetCode669
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/22 8:45
 *@Version 1.0
 **/
public class LeetCode669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return recur(root, low, high);
    }

    //递归得删除此层不在范围中的节点
    private TreeNode recur(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return recur(root.right, low, high);
        if (root.val > high) return recur(root.left, low, high);
        root.left = recur(root.left, low, high);
        root.right = recur(root.right, low, high);
        return root;
    }

}
