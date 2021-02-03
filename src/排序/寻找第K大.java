package 排序;

public class 寻找第K大 {
    private int[] arr;

    public int findKth(int[] a, int n, int K) {
        arr = a;
        return findK(0, n - 1, K);
    }

    private int findK(int left, int right, int k) {
        if (left > right) {
            return -1;
        }
        int index = quickSort(left, right);
        if (index < k - 1) {
            return findK(index + 1, right, k);
        } else if (index > k - 1) {
            return findK(left, index - 1, k);
        } else {
            return arr[index];
        }
    }

    private int quickSort(int begin, int end) {
        int pivot = arr[begin];
        while (begin < end) {
            while (begin < end) {
                if (arr[end] < pivot) {
                    end--;
                } else {
                    arr[begin++] = arr[end];
                    break;
                }
            }
            while (begin < end) {
                if (arr[begin] > pivot) {
                    begin++;
                } else {
                    arr[end--] = arr[begin];
                    break;
                }
            }
        }
        arr[begin] = pivot;
        return begin;
    }
}
