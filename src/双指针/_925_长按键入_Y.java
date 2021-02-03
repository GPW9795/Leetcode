package 双指针;

/**
 * https://leetcode-cn.com/problems/long-pressed-name/
 */
public class _925_长按键入_Y {
    /**
     * 自己写的
     */
    public boolean isLongPressedName(String name, String typed) {
        int len1 = name.length(), len2 = typed.length();
        if (len2 < len1) return false;
        int index1 = 0, index2 = 0;
        char prev = '0';
        while (index1 < len1 && index2 < len2) {
            char n = name.charAt(index1);
            char t = typed.charAt(index2);
            if (n == t) {
                index1++;
                index2++;
                prev = n;
            } else if (t == prev) {
                index2++;
            } else {
                return false;
            }
        }
        if (index1 < len1) {
            return false;
        } else {
            while (index2 < len2) {
                char t = typed.charAt(index2);
                if (t != prev) return false;
                index2++;
            }
        }
        return true;
    }

    /**
     * 优化
     */
    public boolean isLongPressedName1(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}
