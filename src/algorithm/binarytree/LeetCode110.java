package algorithm.binarytree;/**
 *
 */

import algorithm.datastructure.TreeNode;

/**
 *@ClassName LeetCode110
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/27 14:49
 *@Version 1.0
 **/
public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    //递归判断是否平衡
    //求高度是从叶子节点开始算起，后序遍历，前后中。
    private int recur(TreeNode root) {
        //如果为空返回0，说明上层是叶子节点
        if (root == null) {
            return 0;
        }
        //如果子树非平衡，则直接返回-1
        int leftHeight = recur(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = recur(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        //如果左右节点高度差绝对值超过1，返回约定好的-1代表非平衡，否则返回左右子树最大的高度加1代表本节点高度
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : Math.max(leftHeight, rightHeight) + 1;
    }
}
