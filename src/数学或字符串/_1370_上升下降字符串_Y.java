package 数学或字符串;

/**
 * https://leetcode-cn.com/problems/increasing-decreasing-string/
 */
public class _1370_上升下降字符串_Y {
    /**
     * 自己写的
     */
    public static String sortString(String s) {
        if (s == null || s.length() < 2) return s;
        int n = s.length();
        // 记录字符串的频次
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < n) {
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    sb.append((char) ('a' + i));
                    count[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (count[i] != 0) {
                    sb.append((char) ('a' + i));
                    count[i]--;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "spo";
        System.out.println(sortString(s));
    }
}
