package algorithm.sword;/**
 *
 */

/**
 *@ClassName offer15
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/6/30 17:10
 *@Version 1.0
 **/
public class Offer15 {
    /**
     * 需要采用>>>无符号移位
     * time O(log2N) space O(1)
     *
     */
    public  int hammingWeight(int n) {
        int res = 0;
        while (n > 0) {
            res += n & 1;
            n>>>=1;
        }
        return res;
    }

    /**
     * 巧用 n & (n - 1)
     * time O(M) ,M为1的个数 space O(1)
     *         int res = 0;
     *         while(n != 0) {
     *             res++;
     *             n &= n - 1;
     *         }
     *         return res;
     *
     *
     */
}
