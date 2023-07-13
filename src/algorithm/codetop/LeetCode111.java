package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.TreeNode;

import java.util.ArrayDeque;

/**
 *@ClassName LeetCode111
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/9 15:38
 *@Version 1.0
 **/
public class LeetCode111 {
    private int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        recur(root, 0);
        return min;
    }

    private void recur(TreeNode root, int depth) {
        if (root == null) return;
        depth++;
        if (root.left == null && root.right == null && depth < min) {
            min = depth;
            return;
        }
        recur(root.left, depth);
        recur(root.right, depth);
    }

    private void iterate(TreeNode root) {
        if (root == null) return;
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer(root);
        int depth = 0;
        while (!arrayDeque.isEmpty()) {
            int len = arrayDeque.size();
            TreeNode tmpNode = new TreeNode();
            depth++;
            while (len > 0) {
                tmpNode = arrayDeque.poll();
                if (tmpNode.left == null && tmpNode.right == null && depth < min) {
                    min = depth;
                    return;
                }
                if (tmpNode.left != null) arrayDeque.offer(tmpNode.left);
                if (tmpNode.right != null) arrayDeque.offer(tmpNode.right);
                len--;
            }
        }
    }
}
