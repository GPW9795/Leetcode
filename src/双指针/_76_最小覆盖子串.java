package 双指针;

import java.util.HashMap;
import java.util.Map;

public class _76_最小覆盖子串 {
    HashMap<Character, Integer> tmap = new HashMap<>();
    HashMap<Character, Integer> smap = new HashMap<>();

    public String minWindow(String s, String t) {
        // 将t的所有子串个数放到map中
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = -1;
        int resLeft = -1, resRight = -1;
        int sLen = s.length();
        int len = Integer.MAX_VALUE;
        while (right < sLen) {
            right++;
            if (right < sLen && tmap.containsKey(s.charAt(right))) {
                smap.put(s.charAt(right), smap.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (check() && left <= right) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    resLeft = left;
                    resRight = right + 1;
                }
                char c = s.charAt(left);
                if (tmap.containsKey(c)) {
                    smap.put(c, smap.getOrDefault(c, 0) - 1);
                }
                left++;
            }
        }
        return resLeft == -1 ? "" : s.substring(resLeft, resRight);
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            char key = entry.getKey();
            int count = entry.getValue();
            if (smap.getOrDefault(key, 0) < count) {
                return false;
            }
        }
        return true;
    }
}
