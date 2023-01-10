package 算法.codetop;/**
 *
 */

import java.util.Map;

/**
 *@ClassName LeetCode242
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/1/9 10:42
 *@Version 1.0
 **/
public class LeetCode242 {

    public boolean isAnagram(String s, String t) {
        int[] alphaBet = new int[26];
        for (char c : s.toCharArray()) {
            alphaBet[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            alphaBet[c - 'a']--;
        }
        for (int count : alphaBet) {
            if (count != 0) return false;
        }
        return true;
    }

}
