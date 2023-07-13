package algorithm.sword;/**
 *
 */

import java.util.Stack;

/**
 *@ClassName offer09
 *@Description 用两个栈实现队列
 *@Author wuhao51
 *@Date 2022/5/12 20:29
 *@Version 1.0
 **/
public class Offer09 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void CQueue() {
    }

    public void appendTail(int value) {
        stack2.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
        return stack1.isEmpty() ? -1 : stack1.pop();
    }
}
