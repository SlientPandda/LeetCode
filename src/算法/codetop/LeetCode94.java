package 算法.codetop;/**
 *
 */

import 算法.DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *@ClassName LeetCode94
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/6 13:48
 *@Version 1.0
 **/
public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
