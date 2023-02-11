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
}
