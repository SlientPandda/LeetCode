package algorithm.codetop;/**
 *
 */

import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName LeetCode22
 *@Description 括号生成
 *@Author wuhao51
 *@Date 2023/9/1 10:33
 *@Version 1.0
 **/
public class LeetCode22 {
    //回溯法，时间复杂度O（） 第n个卡特兰数
    //时间复杂度O（N）最多递归2n层
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String s = "()";
        backTrack(n, res, 0, 0, new StringBuilder());
        return res;
    }

    //i代表左括号的个数
    private static void backTrack(int n, List<String> res, int i, int j, StringBuilder stringBuilder) {
        if (stringBuilder.length() >= 2 * n) {
            res.add(stringBuilder.toString());
            return;
        }
        if (i < n) {
            stringBuilder.append('(');
            backTrack(n, res, i + 1, j, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (j < i) {
            stringBuilder.append(')');
            backTrack(n, res, i, j + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] agrs) {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(1));
    }
}
