package leetcode.tree;

import java.util.*;

/**
 * 515.在每个树行中找最大值
 * 给定一棵二叉树的根节点root，请找出该二叉树中每一层的最大值。
 */
public class Leetcode_515 {
    public List<Integer> largestValues(TreeNode root) {
        // 初始化结果列表
        List<Integer> list = new ArrayList<>();
        // 初始化队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 如果二叉树为空，则直接返回结果列表
        if (root == null) {
            return list;
        }
        // 将根节点加入队列中
        TreeNode temp = root;
        queue.offer(temp);
        // 开始 BFS 遍历二叉树
        while (!queue.isEmpty()) {
            // 获取当前层的节点数
            int size = queue.size();
            // 初始化存储当前层最大值的列表
            List<Integer> maxList = new ArrayList<>();
            // 遍历当前层的所有节点
            while (size-- > 0) {
                // 弹出当前层的一个节点
                temp = queue.poll();
                // 将该节点的值加入当前层的最大值列表中
                maxList.add(temp.val);
                // 如果该节点有左子节点，则将左子节点加入队列中
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                // 如果该节点有右子节点，则将右子节点加入队列中
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            // 获取当前层的最大值并添加到结果列表中
            int maxNum = Collections.max(maxList);
            list.add(maxNum);
        }
        // 返回结果列表
        return list;
    }
}