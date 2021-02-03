package 栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20_有效的括号_Y {
    private static HashMap<Character, Character> map = new HashMap<>();

    static {
        // key - value
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                else {
                    char left = stack.pop();
                    if (c != map.get(left)) return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                else {
                    char left = stack.pop();
                    if (left == '(' && c != ')') return false;
                    if (left == '{' && c != '}') return false;
                    if (left == '[' && c != ']') return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
