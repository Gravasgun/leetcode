package leetcode.tree;

import java.util.*;

/**
 * 107.二叉树的层序遍历II
 * 给你二叉树的根节点root，返回其节点值自底向上的层序遍历。（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class Leetcode_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 创建一个列表存储最终结果
        List<List<Integer>> result = new ArrayList<>();
        // 创建一个队列，用于 BFS 遍历二叉树
        Queue<TreeNode> queue = new LinkedList<>();
        // 如果根节点为空，则直接返回结果列表
        if (root == null) {
            return result;
        }
        // 将根节点加入队列
        queue.offer(root);
        // BFS 遍历二叉树
        while (!queue.isEmpty()) {
            // 记录当前队列的大小
            int size = queue.size();
            // 创建一个临时列表，用于存储当前层的节点值
            List<Integer> temp = new ArrayList<>();
            // 遍历当前层的所有节点
            while (size > 0) {
                // 弹出队首节点
                TreeNode node = queue.poll();
                // 将节点值添加到临时列表中
                temp.add(node.val);
                // 如果左子节点不为空，则将左子节点加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // 如果右子节点不为空，则将右子节点加入队列
                if (node.right != null) {
                    queue.offer(node.right);
                }
                // 当前层节点数量减 1
                size--;
            }
            // 将临时列表添加到最终结果列表中
            result.add(temp);
        }
        // 反转最终结果列表，得到从下往上的层序遍历结果
        Collections.reverse(result);
        // 返回最终结果列表
        return result;
    }
}
