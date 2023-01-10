package 算法.LC75;/**
 *
 */

/**
 *@ClassName leetcode202
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/7/29 15:58
 *@Version 1.0
 **/
public class leetcode202 {
    //快慢指针方法 time O(logN) space O(1)

    //使用 “快慢指针” 思想，找出循环：“快指针” 每次走两步，“慢指针” 每次走一步，当二者相等时，即为一个循环周期。此时，判断是不是因为 1 引起的循环，是的话就是快乐数，否则不是快乐数。
    //注意：此题不建议用集合记录每次的计算结果来判断是否进入循环，因为这个集合可能大到无法存储；另外，也不建议使用递归，同理，如果递归层次较深，会直接导致调用栈崩溃。不要因为这个题目给出的整数是 int 型而投机取巧。

    public boolean isHappy(int n) {
        int slow = n, fast = sum(n);
        while (fast != 1 && slow != fast) {
            slow = sum(slow);
            fast = sum(sum(fast));
        }
        return fast == 1;
    }
    int sum(int n) {
        int sum = 0;
        while (n > 0) {
            int tmp = n % 10;
            n /= 10;
            sum += tmp * tmp;
        }
        return sum;
    }
}
