package 哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/palindrome-permutation/
 */
public class _266_回文排列_Y {
    /**
     * 自己写的
     */
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            map.put(c[i], map.getOrDefault(c[i], 0) + 1);
        }
        int index = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if ((entry.getValue() & 1) == 0) continue;
            index++;
        }
        return index <= 1;
    }

    /**
     * 利用hashset
     */
    public boolean canPermutePalindrome1(String s) {
        if (s == null || s.length() == 0) return true;
        Set<Character> set = new HashSet<>();
        char[] c = s.toCharArray();
        // 如果add返回值为false，说明set中有这个元素
        for (int i = 0; i < c.length; i++) {
            if (!set.add(c[i])) {
                set.remove(c[i]);
            }
        }
        return set.size() <= 1;
    }
}
