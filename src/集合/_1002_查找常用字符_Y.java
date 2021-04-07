package 集合;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-common-characters/
 */
public class _1002_查找常用字符_Y {
    public static List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        if (A.length == 0) return list;
        // 先将第一个拉进来
        int[] letter = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            int index = A[0].charAt(i) - 'a';
            letter[index]++;
        }

        int[] letterOther = new int[26];
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                int index = A[i].charAt(j) - 'a';
                letterOther[index]++;
            }
            for (int k = 0; k < letter.length; k++) {
                letter[k] = Math.min(letter[k], letterOther[k]);
                letterOther[k] = 0;
            }
        }

        for (int i = 0; i < letter.length; i++) {
            String s = String.valueOf((char) ('a' + i));
            while (letter[i]-- != 0) {
                list.add(s);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] A = {"bella","label","roller"};
        System.out.println(commonChars(A));
    }
}
