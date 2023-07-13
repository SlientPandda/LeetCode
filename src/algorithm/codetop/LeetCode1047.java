package algorithm.codetop;/**
 *
 */

import java.util.ArrayDeque;

/**
 *@ClassName LeetCode1047
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/1 15:43
 *@Version 1.0
 **/
public class LeetCode1047 {
    /**
     * 模拟栈
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().equals(c)) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    /**
     * 直接使用字符串
     * @param s
     * @return
     */
    public static String removeDuplicatesV2(String s) {
        StringBuilder res = new StringBuilder();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            if (top != -1 && s.charAt(i) == res.charAt(top)) {
                res.deleteCharAt(top);
                top--;
            } else {
                res.append(s.charAt(i));
                top++;
            }
        }
        return res.toString();
    }

    /**
     * 双指针法
     * @param s
     * @return
     */
    public static String removeDuplicatesV3(String s) {
        char[] ch = s.toCharArray();
        int fast = 0, slow = 0;
        while (fast < s.length()) {
            ch[slow] = ch[fast];
            if (slow > 0 && ch[slow] == ch[slow - 1]) {
                slow--;
            } else {
                slow++;
            }
            fast++;
        }
        return new String(ch, 0, slow);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicatesV3("abbaca"));
    }
}
