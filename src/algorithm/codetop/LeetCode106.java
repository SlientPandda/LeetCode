package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.TreeNode;

/**
 *@ClassName LeetCode106
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/3 10:06
 *@Version 1.0
 **/
public class LeetCode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return recur(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    //n代表postorder当前值,i,j代表inorder下标范围
    private TreeNode recur(int[] inorder, int[] postorder, int i, int j, int n) {
        if (i > j || n < 0) return null;
        int inindex = 0;
        for (int k = i; k <= j; k++) {
            if (inorder[k] == postorder[n]) inindex = k;
        }
        TreeNode root = new TreeNode(postorder[n]);
        root.right = recur(inorder, postorder, inindex + 1, j, n - 1);
        root.left = recur(inorder, postorder, i, inindex - 1, n - (j - inindex) - 1);
        return root;
    }

}
