package 面试题;/**
 *
 */

/**
 *@ClassName interview0105
 *@Description 面试题 01.05. 一次编辑
 *@Author wuhao51
 *@Date 2022/5/13 16:21
 *@Version 1.0
 **/
public class interview0105 {
    public static boolean oneEditAway(String a, String b) {
        //第一版自己
//        int firstLen = first.length();
//        int secondLen = second.length();
//        if (Math.abs(firstLen - secondLen) > 1) {
//            return false;
//        }
//        if (firstLen > secondLen) return oneEditAway(second, first);
//        int operateNum = 0;
//        int i = 0, j = 0;
//        while (i < firstLen && j < secondLen && operateNum <= 1)
//            if (first.charAt(i) == second.charAt(j)) {
//                i++;
//                j++;
//            } else {
//                if (firstLen == secondLen) {
//                    operateNum++;
//                    i++;
//                    j++;
//                } else {
//                    j++;
//                    operateNum++;
//                }
//            }
//        if (operateNum > 1) return false;
//        return true;
//        三叶版
        int n = a.length(), m = b.length();
        if (Math.abs(n - m) > 1) return false;
        if (n > m) return oneEditAway(b, a);
        int i = 0, j = 0, cnt = 0;
        while (i < n && j < m && cnt <= 1) {
            char c1 = a.charAt(i), c2 = b.charAt(j);
            if (c1 == c2) {
                i++; j++;
            } else {
                if (n == m) {
                    i++; j++; cnt++;
                } else {
                    j++; cnt++;
                }
            }
        }
        return cnt <= 1;
    }

    public static void main(String[] args) {
        oneEditAway("islander", "slander");
    }
}
