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
    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * 示例 1：
     * 输入：s = "(()"
     * 输出：2
     * 解释：最长有效括号子串是 "()"
     * 示例 2：
     * 输入：s = ")()())"
     * 输出：4
     * 解释：最长有效括号子串是 "()()"
     * 示例 3：
     * 输入：s = ""
     * 输出：0
     * 提示：
     * 0 <= s.length <= 3 * 104
     * s[i] 为 '(' 或 ')'
     * @param s
     * @return
     */
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
        for(int i = 0;i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }



}
