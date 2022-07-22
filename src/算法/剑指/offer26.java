package 算法.剑指;/**
 *
 */

import 算法.DataStructure.TreeNode;

/**
 *@ClassName offer26
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/7/22 9:55
 *@Version 1.0
 **/
public class offer26 {
    //time O(MN) MN AB树节点数量 space O(M)
    //遍历树结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //如果A为空树或者B为空树（题意空树不属于任何子树）直接返回false
        //否则判断B是否满足以当前节点A、A左节点、A右节点为根的子树
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    //判断B树是否是A的子树结构
    boolean recur(TreeNode A, TreeNode B) {
        //如果B遍历完成，返回true
        //如果A先为空或者AB节点值不相同 返回false
        //递归判断AB的左子树和右子树
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


}
