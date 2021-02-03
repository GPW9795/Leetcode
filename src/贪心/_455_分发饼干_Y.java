package 贪心;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies/
 */
public class _455_分发饼干_Y {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0) return 0;
        if (s == null || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0, i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                res++;
                i++;
            }
            j++;
        }
        return res;
    }
}
