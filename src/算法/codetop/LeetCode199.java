package 算法.codetop;/**
 *
 */

import 算法.DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName LeetCode199
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/6 19:41
 *@Version 1.0
 **/
public class LeetCode199 {
    public List<Integer> resList = new ArrayList<Integer>();

    public List<Integer> rightSideView(TreeNode root) {
        iterate(root);
        return resList;
    }

    /**
     * 迭代打印出层序节点值
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param root
     */
    public void iterate(TreeNode root) {
        if (root == null) return;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            TreeNode tmpNode = new TreeNode();
            while (len > 0) {
                tmpNode = queue.poll();
                if (tmpNode.left != null) queue.offer(tmpNode.left);
                if (tmpNode.right != null) queue.offer(tmpNode.right);
                len--;
            }
            resList.add(tmpNode.val);
        }
    }
}
