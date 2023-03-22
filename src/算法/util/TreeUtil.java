package 算法.util;/**
 *
 */

import 算法.DataStructure.TreeNode;

/**
 *@ClassName TreeUtil
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/22 19:13
 *@Version 1.0
 **/
public class TreeUtil {
    public static TreeNode arrayToTree(Integer[] arr, int index){
        if(index > arr.length - 1 || arr[index] == null) return null;
        TreeNode root = new TreeNode(arr[index]);
        root.left = arrayToTree(arr, 2 * index + 1);
        root.right = arrayToTree(arr, 2 * index + 2);
        return root;
    }
}
