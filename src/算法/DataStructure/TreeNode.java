package 算法.DataStructure;/**
 *
 */

/**
 *@ClassName TreeNode
 *@Description 二叉树结构
 *@Author wuhao51
 *@Date 2022/5/11 19:57
 *@Version 1.0
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
