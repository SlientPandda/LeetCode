package 算法.codetop;/**
 *
 */

import 算法.DataStructure.TreeNode;

/**
 *@ClassName LeetCode98
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/7 20:18
 *@Version 1.0
 **/
public class LeetCode98 {
    /**
     * 在中序遍历下，输出的二叉搜索树节点的数值是有序序列，可以判断一个序列是不是递增的。
     * 递归中序遍历，存下前一个节点，然后判断是否递增（不能相等）
     * 陷阱1：不能单纯的比较左节点小于中间节点，右节点大于中间节点，需要保持左子树所有节点小于中间节点，右子树所有节点大于中间节点。
     * 陷阱2：用例范围：-2^31 ~ 2^31-1，如果采用暂存int值的方式比较，用例可能会有int最小值，所以这种方法应初始化为long类型。
     * 所以存下前一个节点进行比较可以省去数据范围的考虑
     */
    public boolean isValidBST(TreeNode root) {
        return recur(root);
    }

    private TreeNode pre;

    private boolean recur(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        return isValidBST(root.right);
    }
}
