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
