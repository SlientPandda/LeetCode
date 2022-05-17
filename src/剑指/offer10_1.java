package 剑指;/**
 *
 */

/**
 *@ClassName offer10_1
 *@Description 剑指 Offer 10- I. 斐波那契数列
 *@Author wuhao51
 *@Date 2022/5/16 11:41
 *@Version 1.0
 **/
public class offer10_1 {
    //递归 时间复杂度O(N) 空间复杂度O(1)
    static int mod = (int)1e9+7;
    static int N = 110;
    static int[] cache = new int[N];
    public int fib(int n) {
        if (n <= 1) return n;
        if (cache[n] != 0) return cache[n];
        cache[n] = fib(n - 1) + fib(n - 2);
        cache[n] %= mod;
        return cache[n];
    }
}
