package algorithm.sword;/**
 *
 */

/**
 *@ClassName offer16
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/6/30 17:56
 *@Version 1.0
 **/
public class Offer16 {
    //time O(logN) space O(1)
    //为什么不用三进制计算机基于三进制，位运算更快，并且复杂度都是对数级别，提升有限
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        //如果直接令n<0时 n = -n，由于n是整型，其最大值为2147483647,最小值为-2147483648
        //如果最小值取负，等号左边用整型的话，由于负数补码的机制，其仍为-2147483648，故需要用long值接绝对值
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;

    }
}
