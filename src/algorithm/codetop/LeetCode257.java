package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName LeetCode257
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/27 19:25
 *@Version 1.0
 **/
public class LeetCode257 {
    private List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        recur(root, "");
        return res;
    }

    private void recur(TreeNode root, String path) {
        if (root == null) return;
        StringBuilder sb = new StringBuilder(path);
        sb.append(root.val);
        if (root.left == null && root.right == null) res.add(sb.toString());
        else {
            sb.append("->");
            recur(root.left, sb.toString());
            recur(root.right, sb.toString());
        }
    }
}
