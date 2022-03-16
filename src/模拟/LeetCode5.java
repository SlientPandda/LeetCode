package 模拟;/**
 *
 */

/**
 *@ClassName LeetCode5
 *@Description 5. 最长回文子串
 *@Author wuhao51
 *@Date 2022/3/12 11:40
 *@Version 1.0
 **/
public class LeetCode5 {
    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            //奇数
            String a = getString(s, i, i);
            //偶数
            String b = getString(s, i, i + 1);
            if (a.length() > ans.length()) {
                ans = a;
            }
            if (b.length() > ans.length()) {
                ans = b;
            }
        }
        return ans;
    }

    String getString(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        //subString包括beginIndex，不包括endIndex
        return s.substring(l + 1, r);
    }

}
