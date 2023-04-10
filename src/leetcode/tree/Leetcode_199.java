package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199.二叉树的右视图
 * 给定一个二叉树的根节点root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class Leetcode_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();  // 存放结果的列表
        Queue<TreeNode> queue = new LinkedList<>();  // 辅助层序遍历的队列
        if (root == null) {  // 如果根节点为空，直接返回空列表
            return list;
        }
        queue.offer(root);  // 将根节点加入队列
        while (!queue.isEmpty()) {  // 只要队列不为空，就继续遍历
            int size = queue.size();  // 当前层的节点数量
            int right = size;  // 记录当前层最右侧的节点位置
            int count = 1;  // 记录当前节点的位置，从左往右数
            while (size-- > 0) {  // 遍历当前层的所有节点
                TreeNode temp = queue.poll();  // 取出队首节点
                if (count == right) {  // 如果当前节点是当前层最右侧的节点
                    list.add(temp.val);  // 将当前节点的值加入结果列表
                }
                if (temp.left != null) {  // 如果当前节点有左子节点，加入队列
                    queue.offer(temp.left);
                }
                if (temp.right != null) {  // 如果当前节点有右子节点，加入队列
                    queue.offer(temp.right);
                }
                count++;  // 当前节点位置加1
            }
        }
        return list;  // 返回结果列表
    }
}
