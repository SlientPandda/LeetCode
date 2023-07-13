package algorithm.sword;/**
 *
 */

import algorithm.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName offer07
 *@Description 给出前序序列和中序序列，要求重建二叉树
 *@Author wuhao51
 *@Date 2022/5/11 19:56
 *@Version 1.0
 **/
public class Offer07 {
    int[] predorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.predorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i); //将中序序列的值-下标对应
        }
        return recur(0, 0, preorder.length - 1);
    }

    //输入根下标，左边界下标，右边界下标，建立树结构
    TreeNode recur(int root, int left, int right) {
        if (left > right) return null; //规定结束条件，左边界越过右边界
        TreeNode treeNode = new TreeNode(predorder[root]); //前序序列中根下标对应的值为根值
        int i = map.get(predorder[root]);//根据对应的值从map中获取到根植对应的中序序列的下标
        treeNode.left = recur(root + 1, left, i - 1); //左子树根节点对应中序序列原根节点对应下标右移一位，左边界仍为原左边界，右边界为中序根节点下标左移一
        treeNode.right = recur(root + i - left + 1, i + 1, right);//右子树根节点对应中序序列原根节点对应下标右移左子树长度加一，左边界为中序根节点下标右移一，右边界为原右边界
        return treeNode;//返回根节点
    }
}
