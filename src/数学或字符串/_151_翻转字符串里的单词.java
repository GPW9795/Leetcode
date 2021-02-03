package 数学或字符串;

import java.sql.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class _151_翻转字符串里的单词 {
    public String reverseWords(String s) {
        LinkedList<String> list = new LinkedList<>();
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("")) continue;
            list.addFirst(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
