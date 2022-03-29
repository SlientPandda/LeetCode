package 模拟;/**
 *
 */


import java.util.Arrays;
import java.util.Comparator;

/**
 *@ClassName LeetCode58
 *@Description 58. 最后一个单词的长度
 *@Author wuhao51
 *@Date 2022/3/25 19:18
 *@Version 1.0
 **/
public class LeetCode58 {
    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length != 0) {
                return length;
            }
        }
        return length;
    }
}
