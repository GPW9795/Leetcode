package A剑指offer;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class _40_最小的k个数_Y {
    /**
     * 堆
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0) return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                queue.offer(arr[i]);
            } else {
                if (arr[i] < queue.peek()) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    /**
     * 直接排序
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (k == 0) return new int[0];
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return arr;
    }

    /**
     * 快速选择：快排思想
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        helper(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void helper(int[] arr, int l, int r, int k) {
        if (l >= r) return;
        int pos = quickSort(arr, l, r);
        if (pos == k) {
            return;
        } else if (pos > k) {
            helper(arr, l, pos - 1, k);
        } else {
            helper(arr, pos + 1, r, k);
        }
    }

    public static int quickSort(int[] arr, int begin, int end) {
        int ran = begin + (int) (Math.random() * (end - begin + 1));
        swap(arr, ran, begin);
        int pivot = arr[begin];
        while (begin < end) {
            while (begin < end) {
                if (arr[end] < pivot) {
                    arr[begin++] = arr[end];
                    break;
                } else {
                    end--;
                }
            }
            while (begin < end) {
                if (arr[begin] > pivot) {
                    arr[end--] = arr[begin];
                    break;
                } else {
                    begin++;
                }
            }
        }
        arr[begin] = pivot;
        return begin;
    }

    public static void swap(int[] arr, int p1, int p2) {
        int tmp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 3, 4, 5, 0, 7, 6, 7};
        int k = 9;
        System.out.println(Arrays.toString(getLeastNumbers(arr, k)));
    }
}
