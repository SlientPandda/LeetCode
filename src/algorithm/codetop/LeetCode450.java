package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.TreeNode;

/**
 *@ClassName LeetCode450
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/20 20:17
 *@Version 1.0
 **/
public class LeetCode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        return recur(root, key);
    }

    //返回删除目标节点后的树根节点
    private TreeNode recur(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            //如果左或右为空，则补其另一节点
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            //如果左右不为空，则找到当前节点的左子树的最右侧节点，然后把右子树作为该节点的右子树（反之把左子树作为右子树的最左侧节点的左子树也是一样的）
            TreeNode node = root.left;
            while (node.right != null){
                node = node.right;
            }
            node.right = root.right;
            return root.left;
        }else if(root.val < key) root.right = recur(root.right, key);
        else root.left = recur(root.left, key);
        return root;
    }
}
