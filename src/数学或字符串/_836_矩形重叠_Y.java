package 数学或字符串;

/**
 * https://leetcode-cn.com/problems/rectangle-overlap/
 */
public class _836_矩形重叠_Y {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[0] >= rec2[2]
                || rec1[2] <= rec2[0]
                || rec1[1] >= rec2[3]
                || rec1[3] <= rec2[1]
                || rec1[0] == rec1[2]
                || rec1[1] == rec1[3]
                || rec2[0] == rec2[2]
                || rec2[1] == rec2[3]);
    }

    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        boolean x_overlap = !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0]);
        boolean y_overlap = !(rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
        boolean line = !(rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3]);
        return x_overlap && y_overlap && line;
    }
}
