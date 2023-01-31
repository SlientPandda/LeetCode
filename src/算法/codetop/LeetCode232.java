package 算法.codetop;/**
 *
 */

import java.util.Stack;

/**
 *@ClassName LeetCode232
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/1/31 15:34
 *@Version 1.0
 **/
public class LeetCode232 {
    class MyQueue {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            dumpStack();
            return outStack.pop();
        }

        public int peek() {
            dumpStack();
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void dumpStack() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }
    }
}
