package A剑指offer;

public class _13_机器人的运动范围_Y {
    private int res;
    private int row;
    private int col;
    private int num;

    public int movingCount(int m, int n, int k) {
        row = m;
        col = n;
        num = k;
        int[][] arr = new int[m][n];
        dfs(arr, 0, 0);
        return res;
    }

    public void dfs(int[][] arr, int i, int j) {
        if (!(0 <= i && i < row && 0 <= j && j < col) || arr[i][j] == 1 || !check(i, j)) return;
        arr[i][j] = 1;
        res++;
        dfs(arr, i - 1, j);
        dfs(arr, i + 1, j);
        dfs(arr, i, j - 1);
        dfs(arr, i, j + 1);
    }

    public boolean check(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= num;
    }
}
