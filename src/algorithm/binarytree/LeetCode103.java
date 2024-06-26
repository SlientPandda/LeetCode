package algorithm.binarytree;/**
 *
 */

import algorithm.datastructure.TreeNode;
import algorithm.util.TreeUtil;

import java.util.*;

/**
 *@ClassName LeetCode103
 *@Description TODO
 *@Author wuhao51
 *@Date 2024/6/20 23:19
 *@Version 1.0
 **/
public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 整体流程和层序遍历一样，只不过收集结果的列表有顺序区别
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        boolean leftBegin = true;
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            while (list.size() < size) {
                TreeNode poll = deque.poll();
                if (leftBegin) {
                    list.add(poll.val);
                } else {
                    list.add(0, poll.val);
                }
                if (poll.left != null) deque.offer(poll.left);
                if (poll.right != null) deque.offer(poll.right);
            }
            resList.add(list);
            leftBegin = !leftBegin;
        }
        return resList;
    }
}
