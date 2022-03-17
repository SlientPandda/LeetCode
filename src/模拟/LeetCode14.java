package 模拟;/**
 *
 */

import java.util.Arrays;

/**
 *@ClassName LeetCode14
 *@Description 14. 最长公共前缀
 *@Author wuhao51
 *@Date 2022/3/17 14:43
 *@Version 1.0
 **/
public class LeetCode14 {
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (a, b) -> Integer.compare(a.length(), b.length()));
        String ans = strs[0];
        int i = 0;
        while ( i < strs.length&& !"".equals(ans)) {
            if (!strs[i].substring(0, ans.length()).equals(ans)) {
                i = 0;
                ans = ans.substring(0, ans.length() - 1);
            }
            else{
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        String[] s = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(s));
    }

}