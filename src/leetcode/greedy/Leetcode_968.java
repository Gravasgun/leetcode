package leetcode.greedy;

import leetcode.tree.TreeNode;

/**
 * 968.监控二叉树
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * 计算监控树的所有节点所需的最小摄像头数量。
 */
public class Leetcode_968 {
    int result = 0;

    public int minCameraCover(TreeNode root) {
        //处理根节点，如果根节点未被监视，则需要在根节点处放置摄像头
        if (traversal(root) == 0) {
            result++;
        }
        return result;
    }

    /**
     * 0 表示节点未被监视且需要放置摄像头
     * 1 表示节点已被监视但没有摄像头
     * 2 表示节点已被监视且有摄像头
     * -1 表示错误状态。
     *
     * @param temp
     * @return
     */
    private int traversal(TreeNode temp) {
        // 如果当前节点为空，表示到达叶子节点的子节点，返回状态1
        if (temp == null) {
            return 1;
        }
        // 递归处理左子树
        int left = traversal(temp.left);
        // 递归处理右子树
        int right = traversal(temp.right);
        // 如果左子树或右子树的状态为0，表示该节点的子节点都未被监视
        // 当前节点需要放置摄像头，返回状态2，并增加结果数量
        if (left == 0 || right == 0) {
            result++;
            return 2;
        }
        // 如果左子树或右子树的状态为2，表示该节点的子节点中至少有一个子节点存在摄像头
        // 当前节点已被监视，返回状态1
        if (left == 2 || right == 2) {
            return 1;
        }
        // 如果左子树或右子树的状态为1，表示该节点的子节点中有一个子节点被监视，但没有摄像头(子节点的子节点有摄像头)
        // 当前节点未被监视，返回状态0
        if (left == 1 && right == 1) {
            return 0;
        }
        // 永远不会执行到这里，返回-1表示错误状态
        return -1;
    }
}
