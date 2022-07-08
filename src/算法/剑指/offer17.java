package 算法.剑指;/**
 *
 */

/**
 *@ClassName offer17
 *@Description TODO
 *@Author wuhao51
 *@Date 2022/7/8 10:18
 *@Version 1.0
 **/
public class offer17 {
    public int[] printNumbers(int n) {
        //time O(10^N) space O(1) 建立列表需使用 O(1) 大小的额外空间（ 列表作为返回结果，不计入额外空间 ）。
        int high = (int) Math.pow(10, n);
        int[] res = new int[high-1];
        for (int i = 0; i < high - 1; i++) {
            res[i] = i + 1;
        }
        return res;
    }


}
