package 算法.codetop;/**
 *
 */

import 算法.DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *@ClassName LeetCode101
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/10 16:20
 *@Version 1.0
 **/
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        return recur(root.left, root.right);
    }

    private Boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (right == null || left == null || left.val != right.val)
            return false;
        return recur(left.left, right.right) && recur(left.right, right.left);
    }

    private Boolean iterate(TreeNode root) {
        Deque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer(root.left);
        arrayDeque.offer(root.right);
        while (!arrayDeque.isEmpty()) {
            TreeNode left = arrayDeque.poll();
            TreeNode right = arrayDeque.poll();
            if (left == null && right == null) continue;
            if (right == null || left == null || left.val != right.val)
                return false;
            if (left.left != null) arrayDeque.offer(left.left);
            if (right.right != null) arrayDeque.offer(right.right);
            if (left.right != null) arrayDeque.offer(left.right);
            if (right.left != null) arrayDeque.offer(right.left);
        }
        return true;
    }
}
