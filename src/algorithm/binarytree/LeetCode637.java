package algorithm.binarytree;/**
 *
 */

import algorithm.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName LeetCode637
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/7 10:28
 *@Version 1.0
 **/
public class LeetCode637 {
    public List<Double> resList = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
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
        //创建一个队列，存储当前层级所有节点
        ArrayDeque<TreeNode> que = new ArrayDeque<TreeNode>();
        que.offer(root);
        while (!que.isEmpty()) {
            //获取当前层级长度
            int len = que.size();
            long sum = 0, num = len;
            while (len > 0) {
                //把当前层级的节点值添加到层列表，把左右节点添加到队列中，len--
                TreeNode tmpNode = que.poll();
                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                len--;
                sum += tmpNode.val;
            }
            resList.add((double) sum / num);
        }
    }
}
