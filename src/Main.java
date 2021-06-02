import java.util.*;

public class Main {
    /**
     * R B Y G四种颜色，一个字符串中连续的任意四个不可以有重复，求？对应的R B Y G各有几个
     * eg. ! ! ! ! R B Y G 返回 1 1 1 1
     *     B ! G R B Y G R 返回 0 0 1 0
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
        int len = arr.length;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] color = {'R', 'B', 'Y', 'G'};
        for (char c : color) {
            map.put(c, 0);
        }
        for (int i = 0; i < len; i++) {
            int idx = i;
            int count = 0;
            char c = arr[i];
            while (idx < len) {
                if (arr[idx] != '!') {
                    c = arr[idx];
                } else {
                    count += 1;
                }
                idx += 4;
            }
            if (count > map.get(c)) {
                map.put(c, count);
            }
        }
        for (char c : color) {
            System.out.print(map.get(c) + " ");
        }
    }
}