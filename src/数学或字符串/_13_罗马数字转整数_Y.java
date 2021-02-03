package 数学或字符串;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
public class _13_罗马数字转整数_Y {
    public int romanToInt(String s) {
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");
        System.out.println(s);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += chooseInt(s.charAt(i));
        }
        return sum;
    }

    public int romanToInt1(String s) {
        int sum = 0;
        int prev = chooseInt(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = chooseInt(s.charAt(i));
            if (prev < num) {
                sum -= prev;
            } else {
                sum += prev;
            }
            prev = num;
        }
        sum += prev;
        return sum;
    }

    private int chooseInt(char c){
        switch (c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            case 'a':return 4;
            case 'b':return 9;
            case 'c':return 40;
            case 'd':return 90;
            case 'e':return 400;
            case 'f':return 900;
        }
        return 0;
    }
}
