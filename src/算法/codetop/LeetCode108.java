package 算法.codetop;/**
 *
 */

import javafx.scene.effect.Effect;
import sun.applet.Main;
import 算法.DataStructure.TreeNode;

import java.util.ArrayDeque;

/**
 *@ClassName LeetCode108
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/22 19:18
 *@Version 1.0
 **/
public class LeetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums, 0, nums.length - 1);
    }

    private TreeNode recur(int[] nums, int left, int right) {
        if (left > right) return null;
        int index = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = recur(nums, left, index - 1);
        root.right = recur(nums, index + 1, right);
        return root;
    }
}
