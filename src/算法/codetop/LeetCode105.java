package 算法.codetop;/**
 *
 */

import 算法.DataStructure.TreeNode;

/**
 *@ClassName LeetCode105
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/3 15:45
 *@Version 1.0
 **/
public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recur(preorder, inorder, 0, inorder.length - 1, 0);
    }

    //i，j inorder左右边界，m preorder当前值
    private TreeNode recur(int[] preorder, int[] inorder, int i, int j, int m) {
        if(i > j) return null;
        TreeNode root = new TreeNode(preorder[m]);
        int index;
        for(index = i; index <= j; index++){
            if(inorder[index] == preorder[m]) break;
        }
        root.left = recur(preorder, inorder, i, index - 1, m + 1);
        root.right = recur(preorder, inorder, index + 1, j, m + index - i + 1);
        return root;
    }
}
