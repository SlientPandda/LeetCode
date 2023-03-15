package 算法.codetop;/**
 *
 */

import 算法.DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@ClassName LeetCode501
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/3/14 10:14
 *@Version 1.0
 **/
public class LeetCode501 {
    //存储重复次数最大的数字
    private List<Integer> res;
    //中序遍历前一个节点
    private TreeNode pre;
    //最大重复次数
    private int maxCount;
    //当前计数
    private int count;

    public int[] findMode(TreeNode root) {
        res = new ArrayList<>();
        pre = null;
        count = 0;
        maxCount = 0;
        recur(root);
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    //中序遍历整棵二叉搜索树
    private void recur(TreeNode root) {
        if (root == null) return;
        recur(root.left);
        //如果pre为空或者root与pre值不相等，重置计数为1
        if (pre == null || root.val != pre.val) count = 1;
        else count++;
        //如果当前计数比最大重复次数大，则说明当前列表存储的元素都不再是重复最多的了，清空当前列表
        if (count > maxCount) {
            res.clear();
            res.add(root.val);
            maxCount = count;
        }
        else if (count == maxCount) {
            res.add(root.val);
        }
        pre = root;
        recur(root.right);
    }
}
