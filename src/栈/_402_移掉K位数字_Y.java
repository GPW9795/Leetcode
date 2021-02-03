package 栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/remove-k-digits/
 */
public class _402_移掉K位数字_Y {
    /**
     * 利用栈，每次进栈的元素保留，删除之前的比当前元素大的元素
     */
    public static String removeKdigits1(String num, int k) {
        if (num.length() == k) return "0";
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && c < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            if (c != '0' || !stack.isEmpty()) {
                stack.push(c);
            }
        }
        // 如果此时k大于0，说明还未删完
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    /**
     * 模拟栈，定义当前指针变量
     */
    public static String removeKdigits2(String num, int k) {
        int r = 0, n = num.length();
        char[] res = new char[n];

        // 遍历，逐个入数组
        for (char c : num.toCharArray()) {
            while (r > 0 && k > 0 && res[r - 1] > c) {
                k--;
                r--;
            }
            res[r++] = c;
        }

        // k 还有余，后面大的删起
        while (k-- > 0 && r > 0) r--;

        // 移除头部零
        int l = 0; // 此时才需要 left 指针
        while (l < r && res[l] == '0') l++;
        if (l == r) return "0";

        // 构建，返回
        return new String(res, l, r - l);
    }

    public static String removeKdigits(String num, int k) {
        int r = 0, n = num.length();
        char[] res = new char[n];

        // 遍历，逐个入数组
        for (char c : num.toCharArray()) {
            while (r > 0 && k > 0 && res[r - 1] > c) {
                k--;
                r--;
            }
            res[r++] = c;
        }

        // k 还有余，后面大的删起
        while (k-- > 0 && r > 0) r--;

        // 移除头部零
        int l = 0; // 此时才需要 left 指针
        while (l < r && res[l] == '0') l++;
        if (l == r) return "0";

        // 构建，返回
        return new String(res, l, r - l);
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits2(num, k));
    }
}
