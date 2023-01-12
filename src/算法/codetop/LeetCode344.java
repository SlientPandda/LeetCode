package 算法.codetop;/**
 *
 */

/**
 *@ClassName LeetCode344
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/1/11 16:02
 *@Version 1.0
 **/
public class LeetCode344 {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
