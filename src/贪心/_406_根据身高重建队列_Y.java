package 贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 */
public class _406_根据身高重建队列_Y {
    /**
     * 从高到低排序
     */
    public int[][] reconstructQueue(int[][] people) {
        // 身高降序排列，人数升序排列，相同身高的人人数小的排在前面
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] != p2[0]) {
                    return p2[0] - p1[0];
                } else {
                    return p1[1] - p2[1];
                }
            }
        });
        List<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[list.size()][]);
    }

    /**
     * 从低到高排序
     */
    public static int[][] reconstructQueue1(int[][] people) {
        // 身高升序排列，人数降序排列，相同身高的人人数大的排在前面
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] != p2[0]) {
                    return p1[0] - p2[0];
                } else {
                    return p2[1] - p1[1];
                }
            }
        });
        int n = people.length;
        int[][] res = new int[n][];
        for (int[] person : people) {
            int space = person[1] + 1;
            for (int i = 0; i < n; i++) {
                if (res[i] == null) {
                    space--;
                    if (space == 0) {
                        res[i] = person;
                        break;
                    }
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(reconstructQueue1(people)));
    }

}
