package algorithm.codetop;/**
 *
 */

import java.util.*;

/**
 *@ClassName LeetCode210
 *@Description TODO
 *@Author wuhao51
 *@Date 2024/4/15 10:38
 *@Version 1.0
 **/
public class LeetCode210 {
    // 广度优先遍历图
    // 时间复杂度 O（N+M）遍历一个图需要访问所有节点和所有临边，N 和 M 分别为节点数量和临边数量；
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 找到入度为0的节点，从该节点开始找下一层节点，使下一层节点入度-1，如果不存在环的话，一定可以找到下一层
        // 结果数组
        List<Integer> resList = new ArrayList<>();
        // 入度数组
        int[] indegrees = new int[numCourses];
        // 头节点对应下一层的尾节点的list
        List<List<Integer>> nextLevelList = new ArrayList<>();
        for (int i = 0; i < indegrees.length; i++) {
            nextLevelList.add(new ArrayList<>());
        }
        // 初始化
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            nextLevelList.get(prerequisite[1]).add(prerequisite[0]);
        }
        // 遍历入度数组，目前0度的节点入队
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) queue.add(i);
        }

        // 遍历队列
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            numCourses--;
            resList.add(poll);
            List<Integer> list = nextLevelList.get(poll);
            for (Integer integer : list) {
                if (--indegrees[integer] == 0) queue.add(integer);
            }
        }
        if(numCourses == 0) return resList.stream().mapToInt(Integer::intValue).toArray();
        return new int[]{};
    }


    // 深度优先遍历图，
    // 时间复杂度
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 是否访问过的标志位数组
        int[] flag = new int[numCourses];
        // 头节点对应下一层的尾节点的list
        List<List<Integer>> nextLevelList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            nextLevelList.add(new ArrayList<>());
        }
        // 初始化
        for (int[] prerequisite : prerequisites) {
            nextLevelList.get(prerequisite[1]).add(prerequisite[0]);
        }
        // 遍历每个课程节点进行dfs判断是否有环
        for (int i = 0; i < numCourses; i++) {
            // 存在环，返回失败
            if (dfs(flag, i, nextLevelList)) return false;
        }
        return true;
    }

    //判断是否存在环
    public boolean dfs(int[] flag, int i, List<List<Integer>> nextLevelList) {
        // flag-1 代表本次已访问过，再次访问存在环，直接返回true
        if (flag[i] == 1) return true;
        // flag- -1 代表别的轮次已访问过，不在继续访问
        if (flag[i] == -1) return false;
        // flag-0 代表第一次访问，将其标为1代表本次已访问过
        flag[i] = 1;
        // 递归遍历本节点的下一层节点，判断是否有环
        for (int ii : nextLevelList.get(i)) {
            if (dfs(flag, ii, nextLevelList)) return true;
        }
        // 本轮次已结束，将标志位设为-1，返回false代表不存在环
        flag[i] = -1;
        return false;
    }
}
