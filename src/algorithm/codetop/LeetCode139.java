package algorithm.codetop;/**
 *
 */

import java.util.*;

/**
 *@ClassName LeetCode139
 *@Description TODO
 *@Author wuhao51
 *@Date 2024/4/1 11:06
 *@Version 1.0
 **/
public class LeetCode139 {

    /**
     * dp+剪枝
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        // 明确dp数组     dp[i] 为字符串s 位置为i的子串是否满足要求
        // 确定递推公式    dp[i] = dp[j] && check(s[j..i-1]);
        // dp数组初始化      dp[0] = true
        // 确定递推顺序 i 1 - length  j 0 - i
        Set<String> wordSet = new HashSet<>(wordDict);
        int maxLen = 0;
        for (String s1 : wordSet) {
            maxLen = Math.max(s1.length(), maxLen);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (substring.length() > maxLen) continue;
                if (dp[j] && wordSet.contains(substring)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    private static Set<String> set;
    private static Map<String, Boolean> memo;

    /**
     * dfs+记忆化搜索
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreakDFS(String s, List<String> wordDict) {
        set = new HashSet(wordDict);
        set.add("");
        memo = new HashMap<>();
        memo.put("", true);
        return dfs(s);
    }

    public boolean dfs(String s) {
        if (memo.containsKey(s)) return memo.get(s);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (set.contains(s.substring(i)) && dfs(s.substring(0, i))) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }


}
