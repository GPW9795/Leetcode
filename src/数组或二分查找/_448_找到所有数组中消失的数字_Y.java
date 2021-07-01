package 数组或二分查找;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class _448_找到所有数组中消失的数字_Y {
    /**
     * 使用哈希set
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        for (int num : nums) {
            set.remove(num);
        }
        return new ArrayList<>(set);
    }

    /**
     * 原地修改，使用原数组充当hash表
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                list.add(i+ 1);
            }
        }
        return list;
    }
}
