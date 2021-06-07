package A剑指offer;

/**
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class _58_II_左旋转字符串_Y {
    public static String reverseLeftWords(String s, int n) {
        String right = s.substring(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return right + sb;
    }

    public static String reverseLeftWords1(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static String reverseLeftWords2(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "lrloseumgh";
        int n = 6;
        System.out.println(reverseLeftWords(s, n));
    }
}
