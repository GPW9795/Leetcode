package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/score-of-parentheses/
 */
public class _856_括号的分数_Y {
    /**
     * [(]                # 遇到 ( 往栈添加
     * [(, (]             # 继续添加
     * [(, 1]             # 遇到 ） 合成一个1
     * [(, 1, (]          # 遇到 ( 往栈添加
     * [(, 1, (, (]       # 继续添加
     * [(, 1, (, 1]       # 遇到 ） 合成一个1
     * [(, 1, 2]          # 遇到 ） ，结构就是（1）， 所以计算的话是 1 * 2
     * [6]                # 遇到 ） ，结构是（1，2）， 所以计算的话是 （1 + 2） * 2
     */
    public int scoreOfParentheses(String S) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            String a = Character.toString(c);
            if (a.equals("(")) {
                stack.push(a);
            } else {
                String b = stack.pop();
                if (b.equals("(")) {
                    stack.push("1");
                } else {
                    int tmp = 0;
                    while (!b.equals("(")) {
                        int num = Integer.parseInt(b);
                        tmp += num;
                        b = stack.pop();
                    }
                    stack.push(Integer.toString(2 * tmp));
                }
            }
        }
        int score = 0;
        while (!stack.isEmpty()){
            score += Integer.parseInt(stack.pop());
        }
        return score;
    }


    /**
     * [0, 0]         (
     * [0, 0, 0]      ((
     * [0, 1]         (()
     * [0, 1, 0]      (()(
     * [0, 1, 0, 0]   (()((
     * [0, 1, 1]      (()(()
     * [0, 3]         (()(())
     * [6]            (()(()))
     * <p>
     * 我们用一个栈来维护当前所在的深度，以及每一层深度的得分。
     * 当我们遇到一个左括号 ( 时，我们将深度加一，并且新的深度的得分置为 0。
     * 当我们遇到一个右括号 ) 时，我们将当前深度的得分乘二并加到上一层的深度。
     * 这里有一种例外情况，如果遇到的是 ()，那么只将得分加一。
     */
    public int scoreOfParentheses1(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int score = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int w = stack.pop();
                score = w + Math.max(2 * v, 1);
                stack.push(score);
            }
        }
        return stack.pop();
    }

}
