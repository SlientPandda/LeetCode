package algorithm.codetop;

import jdk.jfr.events.SocketWriteEvent;

public class LeetCode287 {
    /**
     * 使用快慢指针法（又称Floyd判圈算法）判断链表是否存在环，如果存在环找出环的入口，即是重复的数字
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        // 首选说清楚为什么如果满足题意一定存在环，由于给出数字是1-n 闭区间，而nums数组大小为n+1，
        // 那么nums数组中一定至少存放了两个相同的数字，把该题看成链表，节点的值为nums数组元素的值，
        // 节点的指针指向以该节点的值作为数组下标的元素，那么试想如果不存在重复元素，数组元素组成的链表应是一条线段，
        // 但是由于存在重复元素，链表中的某个重复的元素必定会有两个指针指向，那么将会在这一条线段上形成环。
        // 那么问题就转换为找到环的入口处，即是重复元素。我们可以借助快慢指针法来找到这一元素
        if (nums.length == 2) return nums[0];
        // 从入口处开始快慢指针，指针指向节点，本题代表节点的值，初始值都为0
        int fast = 0, slow = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        // fast指针回退到入口处
        fast = 0;
        do {
            slow = nums[slow];
            fast = nums[fast];
        }while (fast != slow);
        // 返回相遇的节点值
        return fast;
    }
}
