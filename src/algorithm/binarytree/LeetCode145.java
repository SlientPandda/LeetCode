package algorithm.binarytree;/**
 *
 */

import algorithm.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName Leet
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/6 13:41
 *@Version 1.0
 **/
public class LeetCode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
