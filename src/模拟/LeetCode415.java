package 模拟;/**
 *
 */

import java.util.Arrays;

/**
 *@ClassName LeetCode415
 *@Description 415. 字符串相加
 *@Author wuhao51
 *@Date 2022/3/22 11:23
 *@Version 1.0
 **/
public class LeetCode415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length()-1, j = num2.length()-1;
        while(i >= 0 || j >= 0 || carry != 0){
            if(i>=0) carry += num1.charAt(i--)-'0';
            if(j>=0) carry += num2.charAt(j--)-'0';
            sb.append(carry%10);
            carry /= 10;
        }
        return sb.reverse().toString();

    }

}
