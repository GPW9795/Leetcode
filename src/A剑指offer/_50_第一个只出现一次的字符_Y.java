package A剑指offer;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class _50_第一个只出现一次的字符_Y {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] carr = s.toCharArray();
        for (char c : carr) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : carr) {
            if (map.get(c)) return c;
        }
        return ' ';
    }
}
