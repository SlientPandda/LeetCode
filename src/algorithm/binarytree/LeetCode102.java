package algorithm.binarytree;/**
 *
 */

import algorithm.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *@ClassName LeetCode102
 *@Description TODO
 *@Author wuhao51
 *@Date 2024/6/25 14:31
 *@Version 1.0
 **/
public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        // 使用队列保存一层的数据
        if (root == null) return resList;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = deque.size();
            while (list.size() < size) {
                TreeNode poll = deque.poll();
                list.add(poll.val);
                if (poll.left != null) deque.offer(poll.left);
                if (poll.right != null) deque.offer(poll.right);
            }
            resList.add(list);
        }
        return resList;
    }
}
