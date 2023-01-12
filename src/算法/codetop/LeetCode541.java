package 算法.codetop;/**
 *
 */

/**
 *@ClassName LeetCode541
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/1/11 16:18
 *@Version 1.0
 **/
public class LeetCode541 {
    private void reverseK(char[] c, int i, int k) {
        while (i < k) {
            char tmp = c[i];
            c[i] = c[k];
            c[k] = tmp;
            i++;
            k--;
        }
    }

    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); ) {
            reverseK(c, i, i + k <= s.length() ? i + k - 1 : s.length() - 1);
            i = i + 2 * k;
        }
        return new String(c);
    }
}
