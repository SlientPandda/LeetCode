package 算法.codetop;/**
 *
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 *@ClassName LeetCode225
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/1/31 16:37
 *@Version 1.0
 **/
public class LeetCode225 {
    class MyStack {
        private Queue<Integer> inQueue;

        public MyStack() {
            inQueue = new LinkedList<>();
        }

        public void push(int x) {
            inQueue.offer(x);
            dumpQueue();
        }

        public int pop() {
            return inQueue.poll();
        }

        public int top() {
            return inQueue.peek();
        }

        public boolean empty() {
            return inQueue.isEmpty();
        }

        //把队列尾元素移动到队列头
        private void dumpQueue() {
            int num = 0, length = inQueue.size();
            while (num < length - 1) {
                inQueue.add(inQueue.poll());
                num++;
            }
        }
    }
}
