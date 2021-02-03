package 动态规划;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/freedom-trail/
 */
public class _514_自由之路_Y {
    /**
     * 动态规划
     * dp[i][j] 表示从前往后拼写出的 key[i] 与 ring[j] 在12点对齐的最小步数，key[i] == ring[j]
     * 初始值：dp[0][i]表示key的第一个字符，ring对齐的最小步数，i = pos[key.charAt(0)]
     * dp[0][i] = Math.min(i, n - i) + 1，n为ring的总字符数
     * dp[i][j] = 上一个对齐所需的最小步数 + 从上一个字符到这一个字符所需的最小步数 + 1
     * 上一个对齐所需的最小步数：dp[i - 1][k]，key[i - 1] == ring[k]，k == pos[key.charAt(i - 1)]
     * 从上一个字符到这一个字符所需的最小步数：Math.min(Math.abs(j - k), n - Math.abs(j - k))
     * 记录ring中字母位置的下标数组为pos，长度为26，每个数组存储一个list，表示字母i在ring中出现的位置list
     * 最终结果为 min{dp[m - 1][i]}，i 为 key[m - 1] == ring[i] 的位置
     */
    public int findRotateSteps1(String ring, String key) {
        int m = key.length();
        int n = ring.length();
        // 初始化位置数组
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        // 动态规划数组
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i : pos[key.charAt(m - 1) - 'a']) {
            res = Math.min(res, dp[m - 1][i]);
        }
        return res;
    }


    /**
     * 深度优先搜素
     */
    private HashMap<Character, List<Integer>> map;
    private int m, n;
    private char[] ringArray, keyArray;
    // 保存从ringI到keyI最少步数
    private int[][] memo;

    public int findRotateSteps(String ring, String key) {
        ringArray = ring.toCharArray();
        keyArray = key.toCharArray();
        m = keyArray.length;
        n = ringArray.length;
        map = new HashMap<>();
        memo = new int[n][m];
        // 初始化map数组
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(ringArray[i])) {
                map.put(ringArray[i], new ArrayList<>());
            }
            map.get(ringArray[i]).add(i);
            Arrays.fill(memo[i], -1);
        }
        return m + dfs(0, 0);
    }

    /**
     * @param ringI 当前ring停留在那个下标位置上
     * @param keyI  需要转到的字符在key中的下标
     * @return 最少步数
     */
    private int dfs(int ringI, int keyI) {
        if (keyI == m) {
            return 0;
        }
        if (memo[ringI][keyI] != -1) {
            return memo[ringI][keyI];
        }
        // 下一次要转到的下标
        List<Integer> list = map.get(keyArray[keyI]);
        int res = Integer.MAX_VALUE;
        for (int i : list) {
            int minStep1 = Math.min(Math.abs(ringI - i), n - Math.abs(ringI - i));
            int minStep2 = dfs(i, keyI + 1);
            res = Math.min(res, minStep1 + minStep2);
        }
        memo[ringI][keyI] = res;
        return res;
    }
}