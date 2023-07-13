package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.TreeNode;

/**
 *@ClassName LeetCode617
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/7 13:54
 *@Version 1.0
 **/
public class LeetCode617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return recur(root1, root2);
    }

    //递归整理root
    //时间复杂度：O(N)
    //空间复杂度：O(N)
    private TreeNode recur(TreeNode root1, TreeNode root2) {
        if (root2 == null) return root1;
        if (root1 == null) return root2;
        root1.val += root2.val;
        root1.left = recur(root1.left, root2.left);
        root1.right = recur(root1.right, root2.right);
        return root1;
    }
}
