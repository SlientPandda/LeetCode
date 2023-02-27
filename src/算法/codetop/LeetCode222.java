package 算法.codetop;/**
 *
 */

import 算法.DataStructure.TreeNode;

import java.util.ArrayDeque;

/**
 *@ClassName LeetCode222
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/11 11:29
 *@Version 1.0
 **/
public class LeetCode222 {

    public int countNodes(TreeNode root) {
        return iterate(root);
    }

    private Integer iterate(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer(root);
        while (!arrayDeque.isEmpty()) {
            int len = arrayDeque.size();
            while (len > 0) {
                TreeNode tmpNode = arrayDeque.poll();
                sum++;
                if (tmpNode.left != null) arrayDeque.offer(tmpNode.left);
                if (tmpNode.right != null) arrayDeque.offer(tmpNode.right);
                len--;
            }
        }
        return sum;
    }

    //完全二叉树的递归算法
    //时间复杂度：O(log n × log n)
    //空间复杂度：O(log n)
    private int recur(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 1, rightDepth = 1;
        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) return (1 << leftDepth) - 1;
        return recur(root.left) + recur(root.right) + 1;
    }
}
