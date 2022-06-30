package 算法.剑指;/**
 *
 */

/**
 *@ClassName offer14_2
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/6/29 15:10
 *@Version 1.0
 **/
public class offer14_2 {
    static int p = 1000000007;

    /**
     * 14_2 大数求余
     *  求余运算规则
     *  (xy)%p=(x%p)(y%p)
     *  (x+y)%p = x%p +y%p
     *  x^a%p =((x^2)^(a/2))%p =
     *  循环求余 、 快速幂求余
     *
     *  2、快速幂求余
     *  a ^ b % p = ((a % p)^b) % p
     */
    //1、循环求余
    //x^a % p= [x^(a-1)%p * x%p]%p
    //time O(N) space O(1)
    public static long loopMod(int x, int a) {
        long res = 1;
        for (int i = 0; i < a; i++) {
            res = (res * x) % p;
        }
        return res;
    }

    //2、快速幂求余
    //a ^ b % p = ((a % p)^b) % p
    //time O(log2N) space O(1)
    public static long fastPower(long x, int a) {
        long res = 1;
        for (; a > 0; a /= 2) {
            if (a % 2 == 1) res = (res * x) % p;
            x = (x * x) % p;
        }
        return res;
    }

    //返回值需要在取余也用括号包起来
    public static int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0) return (int) fastPower(3, a);
        if (b == 1) return (int) (fastPower(3, a - 1) * 4 % p);
        return (int) (fastPower(3, a) * 2 % p);
    }

    public static void main(String[] args) {

        System.out.println(loopMod(3,41));
        System.out.println(fastPower(3,41));
    }


}
