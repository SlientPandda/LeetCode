package algorithm.codetop;/**
 *
 */


/**
 *@ClassName LeetCode10
 *@Description 正则表达式匹配
 *@Author wuhao51
 *@Date 2023/8/30 15:33
 *@Version 1.0
 **/
public class LeetCode10 {
    //1 <= s.length <= 20
    //1 <= p.length <= 20
    //s 只包含从 a-z 的小写字母。
    //p 只包含从 a-z 的小写字母，以及字符 . 和 *。
    //保证每次出现字符 * 时，前面都匹配到有效的字符
    //'.' 匹配任意单个字符
    //'*' 匹配零个或多个前面的那一个元素
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        //res[i][j]代表s的前i个字符和p的前j个字符的匹配情况
        boolean[][] res = new boolean[m + 1][n + 1];
        //s,p都为空串可以匹配，s不为空p为空无法匹配，所以[1,2...m][0]为默认值false，下面循环j从1开始
        res[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    res[i][j] = res[i][j - 2];
                    if (matches(i, j - 1, s, p)) {
                        res[i][j] = res[i - 1][j] || res[i][j];
                    }
                } else {
                    if (matches(i, j, s, p)) {
                        res[i][j] = res[i - 1][j - 1];
                    }
                }
            }
        }
        return res[m][n];
    }

    private boolean matches(int i, int j, String s, String p) {
        if (i == 0) return false;
        if (p.charAt(j - 1) == '.') return true;
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
