package algorithm.simulation;/**
 *
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *@ClassName LeetCode71
 *@Description TODO
 *@Author wuhao51
 *@Date 2024/8/15 17:23
 *@Version 1.0
 **/
public class LeetCode71 {
    public static String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 1; i < path.length(); ) {
            if (path.charAt(i) == '/' && ++i >= 0) continue;
            int j = i + 1;
            while (j < path.length() && path.charAt(j) != '/') j++;
            String item = path.substring(i, j);
            if (item.equals("..")) {
                if (!deque.isEmpty()) deque.pop();
            } else if (!item.equals(".")) {
                deque.push(item);
            }
            i = j + 1;
        }
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.insert(0, "/" + deque.pop());
        }
        if (builder.length() == 0) builder.append("/");
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
    }
}
