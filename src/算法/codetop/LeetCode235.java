package 算法.codetop;/**
 *
 */

import 算法.DataStructure.TreeNode;

/**
 *@ClassName LeetCode235
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/15 13:42
 *@Version 1.0
 **/
public class LeetCode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recur(root, p, q);
    }

    private TreeNode recur(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if(root.val > p.val && root.val > q.val) return recur(root.left, p, q);
        if(root.val < p.val && root.val < q.val) return recur(root.right, p, q);
        return root;
    }
}
