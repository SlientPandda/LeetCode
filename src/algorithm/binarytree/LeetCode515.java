package algorithm.binarytree;/**
 *
 */

import algorithm.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName LeetCode515
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/7 13:45
 *@Version 1.0
 **/
public class LeetCode515 {
    public ArrayList<Integer> resList = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        iterate(root);
        return resList;
    }

    private void iterate(TreeNode root) {
        if (root == null) return;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int max = Integer.MIN_VALUE;
            while (len > 0) {
                TreeNode tmpNode = queue.poll();
                if (tmpNode.val > max) max = tmpNode.val;
                if (tmpNode.left != null) queue.offer(tmpNode.left);
                if (tmpNode.right != null) queue.offer(tmpNode.right);
                len--;
            }
            resList.add(max);
        }
    }
}
