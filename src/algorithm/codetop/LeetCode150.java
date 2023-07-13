package algorithm.codetop;/**
 *
 */

import java.util.ArrayDeque;

/**
 *@ClassName LeetCode150
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/2 9:28
 *@Version 1.0
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 **/
public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        int res = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i]) || "-".equals(tokens[i]) || "*".equals(tokens[i]) || "/".equals(tokens[i])) {
                res = calculate(stack.pop(), stack.pop(), tokens[i]);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public int calculate(int num1, int num2, String cal) {
        switch (cal) {
            case "+":
                return num2 + num1;
            case "-":
                return num2 - num1;
            case "*":
                return num2 * num1;
            case "/":
                return num2 / num1;
        }
        return 0;
    }

}
