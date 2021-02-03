package 数学或字符串;

/**
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class _12_整数转罗马数字_Y {
    /**
     * 贪心算法
     */
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; i < values.length && num >= 0; i++) {
            while (num >= values[i]) {
                sb.append(roman[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 9999;
        System.out.println(intToRoman(num));
    }
}
