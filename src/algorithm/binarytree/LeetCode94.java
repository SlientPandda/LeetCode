package algorithm.binarytree;/**
 *
 */

import algorithm.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName LeetCode94
 *@Description TODO
 *@Author wuhao51
 *@Date 2024/6/25 14:26
 *@Version 1.0
 **/
public class LeetCode94 {
    private List<Integer> resList;

    LeetCode94(){
       resList =  new ArrayList<>();
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        recur(root);
        return resList;
    }

    public void recur(TreeNode root){
        if(root == null) return;
        recur(root.left);
        resList.add(root.val);
        recur(root.right);
    }
}
