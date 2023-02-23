package 算法.codetop;/**
 *
 */

import java.util.ArrayDeque;
import java.util.Stack;

/**
 *@ClassName LeetCode316
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/15 15:23
 *@Version 1.0
 * 时间复杂度 O(N)
 * 空间复杂度 O(N)
 **/
public class LeetCode316 {
    public String removeDuplicateLetters(String s) {
        //对应256个完整acsii字符，标记字符是否已入栈使用的数组
        boolean[] value = new boolean[256];
        //对应256个完整acsii字符，该字符后续可入栈次数的数组
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        //需要保持字典序，字母不重复
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //经过该字符，就将数组值减一
            count[c]--;
            //如果字符已经在栈中，则跳过
            if (value[c]) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek()) {
                //如果当前需要弹出的字符后面没有可以入栈的该字符，则不弹出
                if (count[stack.peek()] == 0) {
                    break;
                }
                //标记要弹出的字符对应的value数组的值为false
                value[stack.peek()] = false;
                stack.pop();
            }
            stack.push(c);
            value[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        //stack的话增强for是栈底到栈顶，arraydeque是队头到队尾（栈顶到栈底）
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
