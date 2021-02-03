package 图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/course-schedule/
 */
public class _207_课程表_Y {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || numCourses == 1) return true;
        // 下标表示某门课，对应的值为每个顶点的出度课程
        List<List<Integer>> edges = new ArrayList<>(numCourses);
        // 初始化
        for (int i = 0; i < numCourses; i++) {
            List<Integer> list = new ArrayList<>();
            edges.add(list);
        }
        // 保存每个顶点的入度
        int[] indeg = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indeg[prerequisites[i][0]]++;
        }
        // 队列保存每次度为0的顶点
        Queue<Integer> queue = new LinkedList<>();
        // 初始化队列
        int index = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                index++;
                queue.offer(i);
            }
        }
        // 循环, 开始拓扑排序
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int next : edges.get(course)) {
                if (--indeg[next] == 0) {
                    index++;
                    queue.offer(next);
                }
            }
        }
        return index == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(new _207_课程表_Y().canFinish(numCourses, prerequisites));
    }
}
