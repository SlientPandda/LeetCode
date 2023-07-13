package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.TreeNode;

import java.util.ArrayDeque;

/**
 *@ClassName LeetCode513
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/2 11:37
 *@Version 1.0
 **/
public class LeetCode513 {
    private int res;
    private int maxDepth;

    public int findBottomLeftValue(TreeNode root) {
//        recur(root, 0);
//        return res;
        return iterate(root);
    }

    //递归法，计算节点深度，如果当前节点深度比最大深度大，则记录节点深度，并把节点值记录下来，由于前序遍历，所以同深度会先记录左边节点。
    private void recur(TreeNode root, int height) {
        if (root == null) return;
        height++;
        if (root.left == null && root.right == null && height > maxDepth) {
            maxDepth = height;
            res = root.val;
        }
        recur(root.left, height);
        recur(root.right, height);
    }

    //迭代法，
    private int iterate(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer(root);
        while (!arrayDeque.isEmpty()) {
            int len = arrayDeque.size();
            res = arrayDeque.peek().val;
            while (len > 0) {
                TreeNode node = arrayDeque.poll();
                if (node.left != null) arrayDeque.offer(node.left);
                if (node.right != null) arrayDeque.offer(node.right);
                len--;
            }
        }
        return res;
    }
}
