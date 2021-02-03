package 贪心;

/**
 * https://leetcode-cn.com/problems/candy/
 */
public class _135_分发糖果_Y {
    /**
     * 正反遍历 + 一个数组
     */
    public int candy1(int[] ratings) {
        int childNum = ratings.length;
        if (ratings == null || childNum == 0) {
            return 0;
        }
        int[] candy = new int[childNum];
        for (int i = 1; i < childNum; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        int sum = childNum + candy[childNum - 1];
        for (int i = childNum - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
            sum += candy[i];
        }
        return sum;
    }

    /**
     * 一次遍历 + 常数级空间复杂度
     */
    public int candy(int[] ratings) {
        // 结果返回值
        int res = 1;
        // 先前值
        int pre = 1;
        // 递减数列长度
        int des_num = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                // 用来补充之前的递减的值
                if (des_num > 0) {
                    // 加上递减数列的糖果数，求和公式：(首项 + 末项) * 项数 / 2
                    res += (1 + des_num) * des_num / 2;
                    // 如果递减个数大于先前值了，需要补充多余的值
                    if (des_num >= pre) {
                        res += (des_num - pre + 1);
                    }
                    pre = 1;
                    des_num = 0;
                }
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                res += pre;
            } else { // 递减
                des_num++;
            }
        }
        // 递减个数不为0
        if (des_num > 0) {
            // 加上递减数列的糖果数
            res += (1 + des_num) * des_num / 2;
            if (des_num >= pre) {
                res += (des_num - pre + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] rating = {1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println(new _135_分发糖果_Y().candy(rating));
    }
}
