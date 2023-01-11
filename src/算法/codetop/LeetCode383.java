package 算法.codetop;/**
 *
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *@ClassName LeetCode383
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/1/10 17:56
 *@Version 1.0
 **/
public class LeetCode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
//        碰到字母表或者key有自然序的，优先考虑数组
        int[] alpha = new int[26];
        for (char c : magazine.toCharArray()) {
            alpha[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (alpha[c - 'a'] <= 0) {
                return false;
            }
            alpha[c - 'a']--;
        }
        return true;
    }
}
