package 动态规划;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-break/
 */
public class _139_单词拆分_Y {
    /**
     * 动态规划
     * dp[i]表示s的前i个字符是否能被拆分
     * dp[i] = dp[j] && set.contains(s.substring(j, i))，有一个为true则为true
     * dp[0]为true即空字符可以被表示
     * 最后返回dp[n]
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    /**
     * dfs + 回溯
     */
    private HashMap<String, Boolean> map = new HashMap<>();

    public boolean wordBreak1(String s, List<String> wordDict) {
        return dfs(s, wordDict);
    }

    private boolean dfs(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        // 记忆化搜索
        if (map.containsKey(s)){
            return map.get(s);
        }
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (s.startsWith(word)) {
                if (dfs(s.substring(word.length()), wordDict)) {
                    // 记录当前结果
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }


    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
    }
}
