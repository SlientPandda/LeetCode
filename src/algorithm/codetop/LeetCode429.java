package algorithm.codetop;/**
 *
 */

import algorithm.datastructure.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName LeetCode429
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/7 10:58
 *@Version 1.0
 **/
public class LeetCode429 {
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(Node root) {
        iterate(root);
        return resList;
    }

    /**
     * 迭代打印出层序节点值
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param root
     */
    public void iterate(Node root) {
        if (root == null) return;
        //创建一个队列，存储当前层级所有节点
        ArrayDeque<Node> que = new ArrayDeque<Node>();
        que.offer(root);
        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            //获取当前层级长度
            int len = que.size();
            while (len > 0) {
                //把当前层级的节点值添加到层列表，把左右节点添加到队列中，len--
                Node tmpNode = que.poll();
                itemList.add(tmpNode.val);
                for (Node node : tmpNode.children) {
                    que.offer(node);
                }
                len--;
            }
            resList.add(itemList);
        }
    }
}
