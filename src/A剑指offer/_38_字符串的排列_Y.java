package A剑指offer;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class _38_字符串的排列_Y {
    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    boolean[] flag;

    public String[] permutation(String s) {
        flag = new boolean[s.length()];
        char[] c = s.toCharArray();
        Arrays.sort(c);
        dfs(c);
        String[] ans = new String[res.size()];
        return res.toArray(new String[res.size()]);
    }

    public void dfs(char[] arr) {
        if (sb.length() == arr.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!flag[i]) {
                if (i > 0 && arr[i] == arr[i - 1] && !flag[i - 1]) continue;
                sb.append(arr[i]);
                flag[i] = true;
                dfs(arr);
                sb.deleteCharAt(sb.length() - 1);
                flag[i] = false;
            }
        }
    }
}
