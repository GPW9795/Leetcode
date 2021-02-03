package 哈希表;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * https://leetcode-cn.com/problems/unique-number-of-occurrences/
 */
public class _1207_独一无二的出现次数_Y {
    /**
     * 自己写的
     */
    static boolean flag = true;

    public static boolean uniqueOccurrences1(int[] arr) {
        if (arr == null || arr.length == 0) return true;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int count = map.get(arr[i]) == null ? 1 : map.get(arr[i]) + 1;
            map.put(arr[i], count);
        }
        Set<Integer> set = new HashSet<>();
        map.forEach((Integer key, Integer value) -> {
            if (set.contains(value)) {
                flag = false;
            }
            set.add(value);
        });
        return flag;
    }

    /**
     * 可以把map.values直接放入set中
     */
    public static boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length == 0) return true;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return new HashSet<>(map.values()).size() == map.size();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(uniqueOccurrences(arr));
    }
}
