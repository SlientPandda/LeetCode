package algorithm.template;/**
 *
 */

import algorithm.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName BinaryTreeTemplate
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/7 13:49
 *@Version 1.0
 **/
public class BinaryTreeTemplate {
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    /**
     * 递归打印出层序的节点值
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param root
     * @param deep
     */
    public void recur(TreeNode root, int deep) {
        if (root == null) return;
        deep++;
        //如果reslist大小小于当前深度，说明第一次进入该层，则new一个空列表，加入结果列表
        if (resList.size() < deep) {
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        //获取当前深度的对应列表，将当前节点值加入列表
        resList.get(deep - 1).add(root.val);
        //递归左右节点
        recur(root.left, deep);
        recur(root.right, deep);
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
            List<Integer> itemList = new ArrayList<Integer>();
            //获取当前层级长度
            int len = que.size();
            while (len > 0) {
                //把当前层级的节点值添加到层列表，把左右节点添加到队列中，len--
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);
                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                len--;
            }
            resList.add(itemList);
        }
    }
}
