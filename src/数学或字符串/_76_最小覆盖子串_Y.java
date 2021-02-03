package 数学或字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class _76_最小覆盖子串_Y {
    private HashMap<Character, Integer> sMap = new HashMap<>();
    private HashMap<Character, Integer> tMap = new HashMap<>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = -1;
        int ansLeft = -1, ansRight = -1;
        int len = Integer.MAX_VALUE;
        int sLen = s.length();
        while (right < sLen) {
            right++;
            if (right < sLen && tMap.containsKey(s.charAt(right))) {
                sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (check() && left <= right) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    ansLeft = left;
                    ansRight = right + 1;
                }
                char l = s.charAt(left);
                if (tMap.containsKey(l)) {
                    sMap.put(l, sMap.getOrDefault(l, 0) - 1);
                }
                left++;
            }
        }
        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight);
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            char key = entry.getKey();
            int count = entry.getValue();
            if (sMap.getOrDefault(key, 0) < count) {
                return false;
            }
        }
        return true;
    }
}
