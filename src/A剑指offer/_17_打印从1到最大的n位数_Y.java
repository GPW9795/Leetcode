package A剑指offer;

public class _17_打印从1到最大的n位数_Y {
    public int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[0];
        }
        int max = (int) (Math.pow(10, n) - 1);
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
