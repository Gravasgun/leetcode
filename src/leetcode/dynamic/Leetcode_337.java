package leetcode.dynamic;

public class Leetcode_337 {
    public int rob(TreeNode root) {
        // result[0]:抢劫当前节点所得到的最大金额
        // result[1]:不抢劫当前节点所得到的最大金额
        int[] result = robTreeHelper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robTreeHelper(TreeNode temp) {
        if (temp == null) {
            return new int[]{0, 0};
        }
        int[] leftResult = robTreeHelper(temp.left);
        int[] rightResult = robTreeHelper(temp.right);
        // 抢劫当前节点 -> 当前节点的值 + 子节点不抢劫的最大金额
        int value1 = temp.val + leftResult[1] + rightResult[1];
        // 不抢劫当前节点 -> 左子树抢劫或不抢劫的最大金额 + 右子树抢劫或不抢劫的最大金额
        int value2 = Math.max(leftResult[0], leftResult[1]) + Math.max(rightResult[0], rightResult[1]);
        return new int[]{value1, value2};
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
