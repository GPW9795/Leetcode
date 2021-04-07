import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int[][] arr = new int[m][2];
        int[] degrees = new int[n + 1];
        for (int i = 0; i < m; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            degrees[arr[i][1]]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (degrees[i] == 0) queue.offer(i);
        }

        int res = n;
        boolean flag = true;
        while (!queue.isEmpty() && flag) {
            int cur = queue.poll();
            if (cur == p) {
                System.out.println(n);
                break;
            }
            res--;
            for (int[] a : arr) {
                if (a[0] != cur) continue;
                if (--degrees[a[1]] == 0) queue.offer(a[1]);
                if (a[1] == p) {
                    flag = false;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= res; i++) {
            sb.append(i);
        }
        System.out.println(sb.toString());
    }
}