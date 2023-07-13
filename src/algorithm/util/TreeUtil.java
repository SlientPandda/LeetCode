package algorithm.util;/**
 *
 */

import algorithm.datastructure.TreeNode;

import javax.sound.midi.Soundbank;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 *@ClassName TreeUtil
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/22 19:13
 *@Version 1.0
 **/
public class TreeUtil {

    /**
     * 有缺点不建议使用，由于二叉树空节点下的子节点一维数组一般会省略。
     * @param arr
     * @param index
     * @return
     */
//    private static TreeNode arrayToTree(Integer[] arr, int index) {
//        if (index > arr.length - 1 || arr[index] == null) return null;
//        TreeNode root = new TreeNode(arr[index]);
//        root.left = arrayToTree(arr, 2 * index + 1);
//        root.right = arrayToTree(arr, 2 * index + 2);
//        return root;
//    }

    /**
     * 层序遍历构建二叉树
     * []
     * @param arr
     * @return
     */
    public static TreeNode arrayToTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        int index = 1;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (index < arr.length) {
            TreeNode pollNode = deque.poll();
            if (pollNode == null) continue;
            TreeNode leftNode = arr[index] == null ? null : new TreeNode(arr[index]);
            index++;
            if (index >= arr.length) break;
            TreeNode rightNode = arr[index] == null ? null : new TreeNode(arr[index]);
            index++;
            pollNode.left = leftNode;
            pollNode.right = rightNode;
            if (leftNode != null) deque.offer(leftNode);
            if (rightNode != null) deque.offer(rightNode);
        }
        return root;
    }
}
