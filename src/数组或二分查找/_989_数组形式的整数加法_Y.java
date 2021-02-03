package 数组或二分查找;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 */
public class _989_数组形式的整数加法_Y {
    // 自己写的
    public static List<Integer> addToArrayForm1(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<Integer> kList = new LinkedList<>();
        boolean flag = true;
        while (K != 0) {
            flag = false;
            kList.addFirst(K % 10);
            K /= 10;
        }
        if (flag) {
            kList.add(0);
        }
        int aN = A.length - 1;
        int kN = kList.size() - 1;
        int mid = 0;
        int car = 0;
        int num = 0;
        while (aN >= 0 && kN >= 0) {
            mid = A[aN--] + kList.get(kN--) + car;
            num = mid - 10 >= 0 ? mid - 10 : mid;
            res.addFirst(num);
            car = mid - 10 >= 0 ? 1 : 0;
        }
        while (aN >= 0) {
            mid = A[aN--] + car;
            num = mid - 10 >= 0 ? mid - 10 : mid;
            res.addFirst(num);
            car = mid - 10 >= 0 ? 1 : 0;
        }
        while (kN >= 0) {
            mid = kList.get(kN--) + car;
            num = mid - 10 >= 0 ? mid - 10 : mid;
            res.addFirst(num);
            car = mid - 10 >= 0 ? 1 : 0;
        }
        if (car > 0) {
            res.addFirst(1);
        }
        return res;
    }

    // 精简版
    public static List<Integer> addToArrayForm(int[] A, int K) {
        int n = A.length - 1;
        LinkedList<Integer> res = new LinkedList<>();
        int x, y, sum;
        int flag = 0;
        while (n >= 0 || K != 0) {
            x = n >= 0 ? A[n] : 0;
            y = K != 0 ? K % 10 : 0;
            sum = x + y + flag;
            flag = sum - 10 >= 0 ? 1 : 0;
            res.addFirst(sum % 10);
            n--;
            K /= 10;
        }
        if (flag > 0) {
            res.addFirst(1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int K = 1;
        System.out.println(addToArrayForm(A, K));
    }
}
