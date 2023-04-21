package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111.二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 */
public class Leetcode_111 {
    /**
     * 方法一：广度优先搜索(层序遍历)
     *
     * @param root
     * @return
     */
    public int minDepthMethodOne(TreeNode root) {
        int result = 0; // 记录二叉树的最小深度
        Queue<TreeNode> queue = new LinkedList<>(); // 创建队列
        if (root == null) { // 如果根节点为空，返回深度0
            return 0;
        }
        TreeNode temp = root; // 记录当前节点
        queue.offer(temp); // 将根节点入队
        while (!queue.isEmpty()) { // 循环遍历队列
            int size = queue.size(); // 获取当前队列的长度
            while (size-- > 0) { // 遍历当前队列中的所有节点
                temp = queue.poll(); // 获取队列头部的节点
                if (temp.left != null) { // 如果该节点有左子节点，将其加入队列
                    queue.offer(temp.left);
                }
                if (temp.right != null) { // 如果该节点有右子节点，将其加入队列
                    queue.offer(temp.right);
                }
                if (temp.left == null && temp.right == null) { // 如果该节点是叶节点，退出循环
                    break;
                }
            }
            result++; // 增加深度计数器
            if (temp.left == null && temp.right == null) { // 如果最后一个节点是叶节点，退出循环
                break;
            }
        }
        return result; // 返回最小深度
    }

    /**
     * 方法二：深度优先搜索(递归)
     *
     * @param root
     * @return
     */
    public int minDepthMethodTwo(TreeNode root) {
        // 如果根节点为空，直接返回深度为0
        if (root == null) {
            return 0;
        }
        // 递归计算左子树的深度
        int leftHeight = minDepthMethodTwo(root.left);
        // 递归计算右子树的深度
        int rightHeight = minDepthMethodTwo(root.right);
        // 如果当前节点的左子树为空，则最小深度为右子树的深度+1
        if (root.left == null) {
            return 1 + rightHeight;
        }
        // 如果当前节点的右子树为空，则最小深度为左子树的深度+1
        if (root.right == null) {
            return 1 + leftHeight;
        }
        // 如果当前节点的左右子树都不为空，则最小深度为左右子树深度的最小值+1
        return 1 + Math.min(leftHeight, rightHeight);
    }
}
