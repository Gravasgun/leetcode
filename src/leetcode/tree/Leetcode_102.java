package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102.二叉树的层序遍历
 * 给你二叉树的根节点root ，返回其节点值的层序遍历。（即逐层地，从左到右访问所有节点）。
 */
public class Leetcode_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 创建一个队列，用于层序遍历二叉树
        Queue<TreeNode> queue = new LinkedList<>();
        // 创建一个列表，用于存储遍历结果
        List<List<Integer>> result = new ArrayList<>();
        // 如果根节点为空，则直接返回结果列表
        if (root == null) {
            return result;
        }
        // 将根节点加入队列
        queue.offer(root);
        // 遍历队列中的所有节点
        while (!queue.isEmpty()) {
            // 获取当前队列中的节点数，即当前层的节点数
            int size = queue.size();
            // 创建一个列表，用于存储当前层的节点值
            List<Integer> temp = new ArrayList<>();
            // 遍历当前层的所有节点
            while (size > 0) {
                // 从队列中取出一个节点
                TreeNode node = queue.poll();
                // 将该节点的值加入到当前层的节点值列表中
                temp.add(node.val);
                // 如果该节点的左子节点不为空，则将其加入到队列中
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // 如果该节点的右子节点不为空，则将其加入到队列中
                if (node.right != null) {
                    queue.offer(node.right);
                }
                // 当前层节点数减一
                size--;
            }
            // 将当前层的节点值列表加入到结果列表中
            result.add(temp);
        }
        // 返回结果列表
        return result;
    }
}
