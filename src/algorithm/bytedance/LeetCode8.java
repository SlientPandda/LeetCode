package algorithm.bytedance;/**
 *
 */

/**
 *@ClassName LeetCode8
 *@Description TODO
 *@Author wuhao51
 *@Date 2024/7/16 14:50
 *@Version 1.0
 **/
public class LeetCode8 {
    // 普通写法
    public int myAtoi(String str) {
        // 去除头尾的空字符
        str = str.trim();
        // 如果为空直接返回0
        if (str.length() == 0) return 0;
        // 如果字符不为数字并且首字符不为+或-符号直接返回0
        if (!Character.isDigit(str.charAt(0))
                && str.charAt(0) != '-' && str.charAt(0) != '+')
            return 0;
        // 结果
        long ans = 0L;
        // 首字符是否为-号的布尔值
        boolean neg = str.charAt(0) == '-';
        // 首字符不为数字初始化为1 为数字初始化为0
        int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;
        // 当i小于字符串长度时 并且i位置的字符为数字时
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            // 计算当前大小
            ans = ans * 10 + (str.charAt(i++) - '0');
            // 如果为正 且结果超过最大值 直接截断为最大值
            if (!neg && ans > Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                break;
            }
            // 如果为负
            if (neg && ans > 1L + Integer.MAX_VALUE) {
                ans = 1L + Integer.MAX_VALUE;
                break;
            }
        }
        // 最后加上正负号
        return neg ? (int) -ans : (int) ans;
    }
}
