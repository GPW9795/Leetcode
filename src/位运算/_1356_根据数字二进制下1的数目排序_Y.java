package 位运算;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 */
public class _1356_根据数字二进制下1的数目排序_Y {
    /**
     * 自己写的
     */
    public static int[] sortByBits1(int[] arr) {
        int len = arr.length;
        if (len < 2) return arr;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Arrays.sort(arr);
        for (int i = 0; i < len; i++) {
            int cnt = countOne(Integer.toBinaryString(arr[i]));
            if (!map.containsKey(cnt)) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                map.put(cnt, list);
            } else {
                map.get(cnt).add(arr[i]);
            }
        }
        int index = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                arr[index] = entry.getValue().get(i);
                index++;
            }
        }
        return arr;
    }

    private static int countOne(String s) {
        char[] c = s.toCharArray();
        int count = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '1') {
                count++;
            }
        }
        return count;
    }

    /**
     * 利用Integer.bitCount计算二进制数的1的个数
     */
    public static int[] sortByBits2(int[] arr) {
        int len = arr.length;
        if (len < 2) return arr;

        for (int i = 0; i < len; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 100000;
        }
        Arrays.sort(arr);
        for (int i = 0; i < len; i++) {
            arr[i] %= 100000;
        }

        return arr;
    }

    /**
     * 递归预处理
     */
    public static int[] sortByBits(int[] arr) {
        int len = arr.length;
        if (len < 2) return arr;

        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            list.add(x);
        }

        int[] bit = new int[10001];
        for (int i = 0; i < 10001; i++) {
            bit[i] = bit[i >> 1] + (i & 1);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                } else {
                    return x - y;
                }
            }
        });

        for (int i = 0; i < len; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 11, 13, 17, 19};
        Integer.bitCount(0);
        System.out.println(Arrays.toString(sortByBits(arr)));
    }
}
