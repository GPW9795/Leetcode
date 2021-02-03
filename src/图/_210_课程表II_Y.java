package 图;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/course-schedule-ii/
 */
public class _210_课程表II_Y {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // 初始化入度数组和访问数组
        int[] indeg = new int[numCourses];
        int[] result = new int[numCourses];
        int index = 0;
        // 存储所有的边
        List<List<Integer>> edges = new ArrayList<>();
        // 初始化edges,每个位置存储对应下标的出边
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        // 初始化队列
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            // 出队并加入到结果中
            int course = queue.poll();
            result[index++] = course;
            // 更新顶点的出边及入度
            for (int next : edges.get(course)) {
                if (--indeg[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }
}
