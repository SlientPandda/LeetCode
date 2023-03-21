package 算法.codetop;/**
 *
 */

import 算法.DataStructure.TreeNode;

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

    private TreeNode recur(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
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
