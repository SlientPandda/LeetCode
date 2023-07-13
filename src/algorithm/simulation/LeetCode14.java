package algorithm.simulation;/**
 *
 */

/**
 *@ClassName LeetCode14
 *@Description 14. 最长公共前缀
 *@Author wuhao51
 *@Date 2022/3/17 14:43
 *@Version 1.0
 **/
public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        if (strs.length == 0) {
            return ans;
        }
        for (int i = 0; i < 200; i++) {
            String s = strs[0];
            if (i >= s.length()) {
                return ans;
            }
            char c = strs[0].charAt(i);
            for (String ss : strs) {
                if (i >= ss.length() || ss.charAt(i) != c) {
                    return ans;
                }
            }
//          原答案是这个：  ans += s.charAt(i); 通过时间10ms 换成valueOf之后为1ms
//          原因是charAt方法返回的char是基本变量，直接与字符串相加涉及到装箱拆箱的操作，而String.valueOf方法返回的是字符串，相加不涉及装拆箱
            ans +=String.valueOf(c);
        }
        return ans;
    }


}