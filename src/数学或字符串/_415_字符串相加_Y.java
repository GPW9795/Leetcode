package 数学或字符串;

/**
 * https://leetcode-cn.com/problems/add-strings/
 */
public class _415_字符串相加_Y {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        // 双指针指向尾部
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
