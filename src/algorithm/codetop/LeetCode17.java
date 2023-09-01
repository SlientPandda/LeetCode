package algorithm.codetop;/**
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@ClassName LeetCode17
 *@Description 电话号码的字母组合
 *@Author wuhao51
 *@Date 2023/8/31 11:03
 *@Version 1.0
 **/
public class LeetCode17 {
    //0 <= digits.length <= 4
    //digits[i] 是范围 ['2', '9'] 的一个数字。
    //时间复杂度O（3^m*4^n）m是输入中对应3个字母的数字个数，n是输入中对应4个字母的数字个数
    //空间复杂度O（m+n）递归层数
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backTrack(digits, 0, map, res, new StringBuilder());

        return res;
    }

    private void backTrack(String digits, int index, Map<Character, String> map, List<String> res, StringBuilder stringBuilder) {
        //1、先写跳出条件
        if (index == digits.length()) {
            res.add(stringBuilder.toString());
            return;
        }
        Character c = digits.charAt(index);
        String s = map.get(c);
        for (char ss : s.toCharArray()) {
            //2、回溯时回到本层后结束前需删除本层添加的结果
            stringBuilder.append(ss);
            backTrack(digits, index + 1, map, res, stringBuilder);
            stringBuilder.deleteCharAt(index);
        }
    }
}
