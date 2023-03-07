package 算法.codetop;/**
 *
 */

import 算法.DataStructure.TreeNode;

import java.util.ArrayDeque;

/**
 *@ClassName LeetCode654
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/3 16:39
 *@Version 1.0
 **/
public class LeetCode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recur(nums, 0, nums.length - 1);
    }

    //递归法，时间复杂度：O(N^2) O(N)
    private TreeNode recur(int[] nums, int i, int j) {
        if (i > j) return null;
        int max = nums[i];
        int index = i;
        for (int k = i; k <= j; k++) {
            if (nums[k] > max) {
                max = nums[k];
                index = k;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = recur(nums, i, index - 1);
        root.right = recur(nums, index + 1, j);
        return root;
    }

    //单调栈解法O(N)
    private TreeNode monotonousStack(int[] nums) {
        //单调递减栈，直接存放节点
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        for (int num : nums) {
            TreeNode node = new TreeNode(num);
            //当栈顶元素小于遍历元素时，由于从前往后处理，所以遍历元素节点一定是左节点指向栈顶元素，弹出元素。
            while (!stack.isEmpty() && stack.peek().val < num) node.left = stack.pop();
            //直到栈非空且栈顶元素大于遍历元素时，由于从前往后处理，所以遍历元素节点一定是栈顶元素的右节点指向
            if (!stack.isEmpty()) stack.peek().right = node;
            stack.push(node);
        }
        return stack.peekLast();
    }

}
