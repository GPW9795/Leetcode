package 二叉树;

public class _270_最接近的二叉搜索树值_Y {
    public int closestValue(TreeNode root, double target) {
        double num = 0, minNum = Double.MAX_VALUE;
        int val = 0, minVal = 0;
        TreeNode node = root;
        while(node != null) {
            val = node.val;
            if (target < node.val) {
                num = node.val - target;
                node = node.left;
            } else {
                num = target - node.val;
                node = node.right;
            }
            if (num < minNum) {
                minNum = num;
                minVal = val;
            }
        }
        return minVal;
    }
}
