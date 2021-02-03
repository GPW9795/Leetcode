package 贪心;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/partition-labels/
 */
public class _763_划分字母区间_Y {
    /**
     * 贪心算法 + 双指针
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int len = S.length();
        if (S == null || len == 0) return result;
        // 记录每个字母最后出现的地方
        int[] last = new int[26];
        for (int i = 0; i < len; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        // 双指针start和end，分别记录每个区间的起始位置和结束位置，[start, end]
        // 贪心：每次的end选择最大的，当遍历到end时说明当前子串结束（前面所有字母都包含在当前子串中）
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        System.out.println(new _763_划分字母区间_Y().partitionLabels(S));
    }
}
