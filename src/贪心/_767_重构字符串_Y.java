package 贪心;

/**
 *
 */
public class _767_重构字符串_Y {
    /**
     * n 为字符串的长度
     * 当 n 为偶数时，奇数下标为 n / 2 个，偶数下标为 n / 2 个，所以任何字母的个数不能超过 n / 2 个
     * 当 n 为奇数时，奇数下标为 n / 2 个，偶数下标为 (n + 1) / 2 个，所以任何字母的个数不能超过 (n + 1) / 2 个
     * 当 n 为偶数时 (n + 1) / 2 == n / 2，因此可以统一为 (n + 1) / 2
     * 当字母的个数不超过(n + 1) / 2时，原则上奇数下标和偶数下标都可以放置，但是如果等于(n + 1) / 2必须放置在偶数下标
     * 因此优先放置奇数下标，奇数下标满了再放置偶数下标
     */
    public String reorganizeString(String S) {
        if (S.length() < 2) return S;
        // 统计每个字符出现的次数以及最大次数
        int n = S.length();
        int maxCount = 0;
        int[] letter = new int[26];
        for (int i = 0; i < n; i++) {
            letter[S.charAt(i) - 'a']++;
            maxCount = Math.max(maxCount, letter[S.charAt(i) - 'a']);
        }
        if (maxCount > (n + 1) / 2) return "";
        // 设置字符数组、奇偶下标和half
        char[] arr = new char[n];
        int even = 0, odd = 1;
        int half = n / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            while (letter[i] > 0 && odd < n && letter[i] <= half) {
                arr[odd] = c;
                letter[i]--;
                odd += 2;
            }
            while (letter[i] > 0) {
                arr[even] = c;
                letter[i]--;
                even += 2;
            }
        }
        return new String(arr);
    }
}
