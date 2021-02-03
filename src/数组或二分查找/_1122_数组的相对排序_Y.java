package 数组或二分查找;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/relative-sort-array/
 */
public class _1122_数组的相对排序_Y {
    /**
     * 自己写的，利用map实现
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        int[] arr = new int[arr1.length];
        int idx = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < map.get(arr2[i]); j++) {
                arr[idx] = arr2[i];
                idx++;
            }
            map.remove(arr2[i]);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            for (int i = 0; i < entry.getValue(); i++) {
                arr[idx] = entry.getKey();
                idx++;
            }
        }
        Arrays.sort(arr, arr.length - count, arr.length);
        return arr;
    }

    /**
     * 计数排序，速度最快
     */
    public static int[] relativeSortArray1(int[] arr1, int[] arr2) {
        // 求出最大值
        int max = 0;
        for (int i = 0; i < arr1.length; i++) {
            max = Math.max(max, arr1[i]);
        }
        // 设置计数排序数组并初始化
        int[] count = new int[max + 1];
        for (int i = 0; i < arr1.length; i++) {
            count[arr1[i]]++;
        }
        // 设置结果数组
        int[] res = new int[arr1.length];
        int idx = 0;
        // 填入arr2的数值
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < count[arr2[i]]; j++) {
                res[idx++] = arr2[i];
            }
            count[arr2[i]] = 0;
        }
        // 填入剩下的值
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < count[i]; j++) {
                res[idx++] = i;
            }
        }
        return res;
    }

    /**
     * 自定义排序
     */
    public static int[] relativeSortArray2(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            list.add(arr1[i]);
        }
        // 利用Collections.sort做自定义排序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                if (map.containsKey(x) || map.containsKey(y)) {
                    return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
                }
                return x - y;
            }
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(relativeSortArray2(arr1, arr2)));
    }
}
