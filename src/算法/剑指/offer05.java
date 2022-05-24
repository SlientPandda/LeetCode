package 算法.剑指;/**
 *
 */

/**
 *@ClassName offer05
 *@Description 替换空格
 *@Author wuhao51
 *@Date 2022/4/26 16:06
 *@Version 1.0
 **/
public class offer05 {
    public String replaceSpace(String s) {
        // replaceAll支持正则表达式，而replace不支持，二者都是替换全部出现的地方
        // return s.replaceAll(" ", "%20");
        // 时空 O(N) O(N)
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') sb.append("%20");
            else sb.append(c);
        }
        return sb.toString();
    }
}
