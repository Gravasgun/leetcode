package leetcode.dynamic;

import leetcode.tree.TreeNode;

/**
 * 337.打家劫舍III
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 */
public class Leetcode_337 {
    public int rob(TreeNode root) {
        // 调用辅助函数robTree计算以根节点为起点的最大抢劫金额
        int[] result = robTree(root);
        // 返回不抢劫根节点和抢劫根节点两种情况下的较大值
        return Math.max(result[0], result[1]);
    }

    // 辅助函数，计算以当前节点为根节点的二叉树中的最大抢劫金额
    private int[] robTree(TreeNode temp) {
        if (temp == null) {
            // 若当前节点为空，则返回长度为2的数组，表示不抢劫和抢劫当前节点的最大金额均为0
            return new int[]{0, 0};
        }
        // 递归计算左子树和右子树的最大抢劫金额
        int[] leftResult = robTree(temp.left);
        int[] rightResult = robTree(temp.right);
        // value1表示不抢劫当前节点，取左子树和右子树最大抢劫金额之和
        int value1 = Math.max(leftResult[0], leftResult[1]) + Math.max(rightResult[0], rightResult[1]);
        // value2表示抢劫当前节点，取当前节点值加上左子树不抢劫的最大金额和右子树不抢劫的最大金额之和
        int value2 = temp.val + leftResult[0] + rightResult[0];
        // 返回当前节点的最大抢劫金额，分别表示不抢劫当前节点和抢劫当前节点的两种情况
        return new int[]{value1, value2};
    }
}
