package 堆;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-words/
 */
public class _692_前K个高频单词_Y {
    /**
     * 最小堆和哈希表实现
     */
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1) != map.get(o2) ? map.get(o1) - map.get(o2) : o2.compareTo(o1);
            }
        });
        int index = 0;
        // 先添加，如果堆的数量大于k了就弹出当前最小的，最后结果就是前k个最大的，但是按从小到大排
        for (String word : map.keySet()) {
            queue.offer(word);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(queue.poll());
        }
        // 反转得到最终结果
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(topKFrequent(words, k));
    }
}
