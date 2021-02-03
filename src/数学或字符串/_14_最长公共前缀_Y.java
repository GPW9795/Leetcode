package 数学或字符串;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class _14_最长公共前缀_Y {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while(j < strs[i].length() && j < prefix.length()){
                if (strs[i].charAt(j) != prefix.charAt(j)) {
                    break;
                }
                j++;
            }
            prefix = strs[i].substring(0, j);
            if (prefix == "") return prefix;
        }
        return prefix;
    }
}
