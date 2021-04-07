import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = i; j < n; j++) {
                num |= nums[j];
                if (num <= target) {
                    res++;
                }
            }
        }
        res = res % 1000000007;
        System.out.println(res);
    }
}