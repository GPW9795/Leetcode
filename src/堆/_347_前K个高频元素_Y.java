package 堆;

import java.lang.reflect.Array;
import java.util.*;

public class _347_前K个高频元素_Y {
    /**
     * 堆实现
     */
    public static int[] topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (index < k) {
                queue.offer(entry.getKey());
                index++;
            } else {
                if (entry.getValue() > map.get(queue.peek())) {
                    queue.poll();
                    queue.offer(entry.getKey());
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
     * 快速排序实现
     */
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }

        quickSort(list, 0, list.size() - 1, k);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[0];
        }
        return res;
    }

    private static void quickSort(List<int[]> list, int left, int right, int k) {
        int pivotId = (int) (Math.random() * (right - left + 1)) + left;
        int pivot = list.get(pivotId)[1];
        Collections.swap(list, right, pivotId);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (list.get(j)[1] >= pivot) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        i++;
        Collections.swap(list, i, right);
        if (k < i - left + 1) {
            quickSort(list, left, i - 1, k);
        } else if (k > i - left + 1) {
            quickSort(list, i + 1, right, k - (i - left + 1));
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6};
        int k = 10;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
