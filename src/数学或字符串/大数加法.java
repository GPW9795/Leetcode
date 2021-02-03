package 数学或字符串;

public class 大数加法 {
    public static String solve(String s, String t) {
        StringBuilder sb = new StringBuilder();
        int m = s.length(), n = t.length();
        int i = m - 1, j = n - 1;
        int flag = 0;
        int sum = 0;
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? s.charAt(i) - '0' : 0;
            int b = j >= 0 ? t.charAt(j) - '0' : 0;
            sum = a + b + flag;
            sb.append(sum % 10);
            flag = sum / 10;
            i--;
            j--;
        }
        if (flag == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "1";
        String t = "99";
        System.out.println(solve(s, t));
    }
}
