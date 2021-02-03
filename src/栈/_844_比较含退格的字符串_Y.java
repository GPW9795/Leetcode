package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class _844_比较含退格的字符串_Y {
    /**
     * 栈
     */
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> strS = getStack(S);
        Stack<Character> strT = getStack(T);
        while (!strS.isEmpty() && !strT.isEmpty()) {
            if (strS.pop() != strT.pop()) return false;
        }
        return strS.isEmpty() && strT.isEmpty();
    }

    private Stack<Character> getStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return stack;
    }

    /**
     * 双指针，从后往前遍历，定义两个指针i、j和skipS、skipT
     * 当遇到'#'时skip++
     * 当遇到普通字母时，（1）skip不为0，i--；（2）skip为0，退出循环，二者比对
     * 官方解释----------------------------------------------------------------------------
     * 一个字符是否会被删掉，只取决于该字符后面的退格符，而与该字符前面的退格符无关。因此当我们逆序地遍历字符串，就可以立即确定当前字符是否会被删掉。
     *
     * 具体地，我们定义skip 表示当前待删除的字符的数量。每次我们遍历到一个字符：
     * （1）若该字符为退格符，则我们需要多删除一个普通字符，我们让skip加1；
     * （1）若该字符为普通字符：
     * A. 若skip为0，则说明当前字符不需要删去；
     * B. 若skip不为0，则说明当前字符需要删去，我们让skip减1。
     *
     * 我们定义两个指针，分别指向两字符串的末尾。每次我们让两指针逆序地遍历两字符串，直到两字符串能够各自确定一个字符，然后将这两个字符进行比较。
     * 重复这一过程直到找到的两个字符不相等，或遍历完字符串为止。
     */
    public boolean backspaceCompare1(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) return false;
            } else {
                if (i >= 0 || j >= 0) return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
