package 贪心;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/gas-station/
 */
public class _134_加油站_Y {
    /**
     * 自己写的暴力法
     */
    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        List<Integer> list = new LinkedList<>();
        // 选出可以作为起点的点，减少遍历次数
        for (int i = 0; i < n; i++) {
            if (gas[i] >= cost[i]) {
                list.add(i);
            }
        }
        for (int i : list) {
            int left = 0;
            boolean ans = true;
            for (int j = i; j < i + n; j++) {
                int idx = j >= n ? j - n : j;
                left += gas[idx] - cost[idx];
                if (left < 0) {
                    ans = false;
                    break;
                }
            }
            if (ans) return i;
        }
        return -1;
    }

    /**
     * 寻找最低点，如果总油耗都大于0，则可以跑回终点
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int left = 0;
        int minIndex = -1;
        int minGas = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            left += gas[i] - cost[i];
            if (left < minGas) {
                minGas = left;
                minIndex = i;
            }
        }
        return left < 0 ? -1 : (minIndex + 1) % n;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
