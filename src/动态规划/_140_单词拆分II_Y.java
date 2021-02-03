package 动态规划;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-break-ii/
 */
public class _140_单词拆分II_Y {
    /**
     * 错解：超出时间限制
     */
    private List<String> res1;
    private List<String> list;

    public List<String> wordBreak1(String s, List<String> wordDict) {
        res1 = new ArrayList<>();
        list = new ArrayList<>();
        dfs1(s, wordDict);
        return res1;
    }

    private void dfs1(String s, List<String> wordDict) {
        if (s.length() == 0) {
            res1.add(String.join(" ", list));
            return;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (s.startsWith(word)) {
                list.add(word);
                dfs1(s.substring(word.length()), wordDict);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * 回溯 + 动态规划 + 剪枝，动态规划用于剪枝否则会超出时间限制
     */
    private boolean[] dp;
    private int n;
    private Set<String> set;
    private Deque<String> deque;
    private List<String> res;

    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        n = s.length();
        // dp[i]表示s的前i个字符是否能被wordDict表示
        dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        res = new ArrayList<>();
        // 如果s可以被wordDict表示再进行递归回溯
        if (dp[n]) {
            deque = new ArrayDeque<>();
            dfs(s, n);
            return res;
        }
        return res;
    }

    private void dfs(String s, int len) {
        if (len == 0) {
            res.add(String.join(" ", deque));
        }
        for (int i = len - 1; i >= 0; i--) {
            String prefix = s.substring(i, len);
            if (dp[i] && set.contains(prefix)) {
                deque.addFirst(prefix);
                dfs(s, i);
                deque.removeFirst();
            }
        }
    }
}
