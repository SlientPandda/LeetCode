package 算法.codetop;/**
 *
 */

/**
 *@ClassName LeetCode201
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/25 11:24
 *@Version 1.0
 **/
public class LeetCode201 {
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        while (m < n) {
            m = m >> 1;
            n = n >> 1;
            res++;
        }
        return m << res;
    }
}
