package algorithm.codetop;/**
 *
 */

import java.util.HashMap;
import java.util.LinkedList;

/**
 *@ClassName LeetCode20
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/1 10:45
 *@Version 1.0
 * 时间复杂度 O()
 * 空间复杂度
 **/
public class LeetCode20 {
    private HashMap<Character, Character> map = new HashMap<Character, Character>() {{
        put('[', ']');
        put('{', '}');
        put('(', ')');
    }};

    public boolean isValid(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<>();
        //避免无谓的拆装箱，节省时间
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            }//右值，如果找到的左值与栈里弹出的不一致，则返回false
            else if (stack.isEmpty() || !map.get(stack.pop()).equals(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
