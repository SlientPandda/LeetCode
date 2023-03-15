package 算法.codetop;/**
 *
 */

import 算法.DataStructure.TreeNode;

/**
 *@ClassName LeetCode236
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/15 9:43
 *@Version 1.0
 **/
public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recur(root, p, q);
    }

    private TreeNode recur(TreeNode root, TreeNode p, TreeNode q) {
        //找到一个节点立即返回，由于题目给出的条件是pq一定存在，故要么公共节点在上级节点，要么是p或者q
        if (root == p || root == q || root == null) return root;
        TreeNode left = recur(root.left, p, q);
        TreeNode right = recur(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null && right == null) return left;
        else if (left == null && right != null) return right;
        else return null;
    }
}
