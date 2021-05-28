package A剑指offer;

public class _05_替换空格 {
    public static void main(String[] args) {

    }

    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
