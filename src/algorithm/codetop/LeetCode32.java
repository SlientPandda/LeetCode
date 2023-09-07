package algorithm.codetop;/**
 *
 */

import java.util.ArrayDeque;

/**
 *@ClassName LeetCode32
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/9/6 10:22
 *@Version 1.0
 **/
public class LeetCode32 {
    public int longestValidParentheses(String s) {
        return solution1(s);
    }

    //栈，利用有效括号字符串性质：1、任意前缀左括号数量大于右括号数量；2、左右括号数量相等；
    //当遇到不能匹配的右括号时，则为分割的边界。为了便于编码，设置一个虚拟右括号在栈底，作为第一个不能匹配的右括号。
    //从左到右扫描字符串，遇到左括号则入栈，右括号则弹出栈顶元素以示匹配成功，并判断当前栈是否为空，
    // 如果不为空则以栈顶元素下标为起点计算长度，并且与当前结果长度比较，更长者计为结果长度。
    // 如果为空则说明栈底右括号被弹出，则当前元素为不能匹配的右括号，作为新的边界元素入栈。
    //时间复杂度O(N)，空间复杂度O(N)
    private int solution1(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    private int solution2(String s) {
        //设 dp 数组，其中第 i个元素表示以下标为 i 的字符结尾的最长有效子字符串的长度。
        int[] dp = new int[s.length()];
        int res = 0;
        //dp[0]一定为0，所以从1开始
        for (int i = 1; i < s.length(); i++) {
            //此时为左括号 无法与之前字符组成有效括号对
            if (s.charAt(i) == '(') dp[i] = 0;
                //此时为右括号，当前一个字符为左括号时，其能组成有效括号对，则dp[i]为dp[i-2]+2（i和i-1组成的括号对）
            else if (s.charAt(i - 1) == '(') dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                //当前一个字符为右括号时，其若能组成有效括号对，必然要求s[i-1]位置必然是有效得括号对，否则s[i]无法和前面对字符组成有效括号对。
                // 此时我们需要找到和s[i]配对位置，并判断其是否是'('即可。和其配对的位置为i-dp[i-1]-1。
                // 如果该位置为(则i位置最长有小括号长度为i-1位置的最长括号长度加上当前位置新增的2。那么dp[i]=dp[i-1]+2。
                // 需要注意的是，如果i-dp[i-1]-1和i组成了有效括号对，这将是一段独立的有效括号序列。
                // 如果之前的子序列是形如（...）这种序列，那么当前位置的最长有效括号长度还需要加上这一段。
                // 所以dp[i] = dp[i-1]+2+ dp[i-dp[i-1]-2]
            else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(')
                dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
