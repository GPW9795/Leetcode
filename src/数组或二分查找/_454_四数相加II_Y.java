package 数组或二分查找;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/4sum-ii/
 */
public class _454_四数相加II_Y {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int n = A.length;
        // 将AB的值存入map中
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sumAB = A[i] + B[j];
                map.put(sumAB, map.getOrDefault(sumAB, 0) + 1);
            }
        }
        // 用CD和的相反数寻找map
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sumCD = -(C[i] + D[j]);
                if (map.containsKey(sumCD)) {
                    res += map.get(sumCD);
                }
            }
        }
        return res;
    }
}
