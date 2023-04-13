package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637.二叉树的层平均值
 * 给定一个非空二叉树的根节点 root，以数组的形式返回每一层节点的平均值。
 */
public class Leetcode_637 {

    /**
     * 计算二叉树每一层的节点平均值
     *
     * @param root 二叉树的根节点
     * @return 每一层节点的平均值列表
     */
    public List<Double> averageOfLevels(TreeNode root) {
        // 创建结果列表
        List<Double> list = new ArrayList<>();
        // 创建队列用于广度优先搜索
        Queue<TreeNode> queue = new LinkedList<>();
        // 如果根节点为空，则直接返回空列表
        if (root == null) {
            return list;
        }
        // 将根节点加入队列
        queue.offer(root);
        // 初始化当前节点为根节点
        TreeNode temp = root;
        // 遍历整个二叉树
        while (!queue.isEmpty()) {
            // 记录当前层节点的个数
            int size = queue.size();
            // 创建存储当前层节点值的列表
            List<Double> averageList = new ArrayList<>();
            // 处理当前层的所有节点
            while (size-- > 0) {
                // 弹出队列中的节点
                temp = queue.poll();
                // 将节点的值添加到当前层列表中
                averageList.add((double) temp.val);
                // 将左子节点加入队列
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                // 将右子节点加入队列
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            // 计算当前层节点值的平均值
            double average = average(averageList);
            // 将平均值添加到结果列表中
            list.add(average);
        }
        // 返回结果列表
        return list;
    }

    /**
     * 计算列表中所有数的平均值
     *
     * @param averageList 存储数值的列表
     * @return 平均值
     */
    private double average(List<Double> averageList) {
        // 初始化平均值为0
        double average = 0;
        // 遍历列表中的所有数
        for (int i = 0; i < averageList.size(); i++) {
            // 将所有数加起来
            average += averageList.get(i);
        }
        // 计算平均值
        average = average / averageList.size();
        // 返回平均值
        return average;
    }
}
