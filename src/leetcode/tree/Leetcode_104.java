package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104.二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Leetcode_104 {
    public int maxDepth(TreeNode root) {
        int result = 0; // 初始化深度为0
        Queue<TreeNode> queue = new LinkedList<>(); // 创建一个队列用于遍历树
        if (root == null) { // 特判：如果根节点为空，直接返回0
            return 0;
        }
        TreeNode temp = root; // 用一个变量temp来保存当前节点
        queue.offer(temp); // 将根节点入队
        while (!queue.isEmpty()) { // 只要队列不为空，就一直循环
            int size = queue.size(); // 获取当前队列中元素的个数
            while (size-- > 0) { // 对于每个元素，一次出队，再把它的左右子节点入队
                temp = queue.poll(); // 出队一个元素
                if (temp.left != null) { // 如果该节点有左子节点，将其入队
                    queue.offer(temp.left);
                }
                if (temp.right != null) { // 如果该节点有右子节点，将其入队
                    queue.offer(temp.right);
                }
            }
            result++; // 每次循环结束，深度加1
        }
        return result; // 最后返回深度
    }
}
