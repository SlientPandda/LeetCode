package 算法.剑指;/**
 *
 */

/**
 *@ClassName offer10_2
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/5/17 11:12
 *@Version 1.0
 **/
public class offer10_2 {
    static int mod = (int) 1e9 + 7;
    static int N = 110;
    static int[] dic = new int[N];

    public int numWays(int n) {
        if (n <= 1) return 1;
        if (dic[n] != 0) return dic[n];
        dic[n] = numWays(n - 1) + numWays(n - 2);
        dic[n] %= mod;
        return dic[n];
    }
}
