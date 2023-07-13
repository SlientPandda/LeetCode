package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.TreeNode;

/**
 *@ClassName LeetCode104
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/9 14:02
 *@Version 1.0
 **/
public class LeetCode104 {
    private int max = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        recur(root, 0);
        return max;
    }

    private void recur(TreeNode root, int depth) {
        if (root == null) return;
        if (++depth > max) max = depth;
        recur(root.left, depth);
        recur(root.right, depth);
    }
}
