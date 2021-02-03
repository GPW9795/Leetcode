package 堆;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 */
public class _973_最接近原点的K个点_K {
    /**
     * 自己写的
     */
    public int[][] kClosest(int[][] points, int K) {
        if (K == 0) return null;
        if (K == points.length) return points;
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.weight - o1.weight;
            }
        });
        int index = 0;
        for (int i = 0; i < points.length; i++) {
            Node node = new Node(points[i]);
            if (index < K) {
                queue.offer(node);
                index++;
            } else if (node.weight > queue.peek().weight) {
                queue.poll();
                queue.offer(node);
            }
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = queue.poll().val;
        }
        return res;
    }

    class Node {
        private int[] val;
        private int weight;

        public Node(int[] val) {
            this.val = val;
            this.weight = val[0] * val[0] + val[1] * val[1];
        }
    }

    /**
     * 答案的最小堆
     */
    public int[][] kClosest1(int[][] points, int K) {
        if (K == 0) return null;
        if (K >= points.length) return points;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < K; i++) {
            queue.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        for (int i = K; i < points.length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dist < queue.peek()[0]) {
                queue.poll();
                queue.offer(new int[]{dist, i});
            }
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = points[queue.poll()[1]];
        }
        return res;
    }

    /**
     * 直接排序
     */
    public int[][] kClosest2(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[0] * o2[0] + o2[1] * o2[1]) - (o1[0] * o1[0] + o1[1] * o1[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, K);
    }

    /**
     * 快速排序的思想
     */
    Random random = new Random();

    public int[][] kCloses3(int[][] points, int K) {
        quickSort(points, 0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void quickSort(int[][] points, int left, int right, int K) {
        int pivotId = left + random.nextInt(right - left + 1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points, pivotId, right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if (dist <= pivot) {
                ++i;
                swap(points, i, j);
            }
        }
        i++;
        swap(points, i, right);
        if (K < i - left + 1) {
            quickSort(points, left, i - 1, K);
        } else if (K > i - left + 1) {
            quickSort(points, i + 1, right, K - (i - left + 1));
        }
    }

    private void swap(int[][] points, int i, int j) {
        if (i == j) return;
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }
}
