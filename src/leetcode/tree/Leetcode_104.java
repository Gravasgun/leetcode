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
    /**
     * 方法一：广度优先遍历，层序遍历
     * @param root
     * @return
     */
    public int maxDepthMethodOne(TreeNode root) {
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

    /**
     * 方法二：深度优先遍历，递归
     * @param root
     * @return
     */
    public int maxDepthMethodTwo(TreeNode root) {
        return maxHeight(root); // 返回二叉树的最大深度
    }

    // 计算二叉树中每个节点的高度，并返回二叉树的最大高度
    private int maxHeight(TreeNode temp) {
        if (temp == null) { // 如果当前节点为null，则返回0，递归终止条件
            return 0;
        }
        int leftHeight = maxHeight(temp.left); // 计算左子树的高度
        int rightHeight = maxHeight(temp.right); // 计算右子树的高度
        int height = 1 + Math.max(leftHeight, rightHeight); // 当前节点的高度为左右子树中更大的高度再加上1
        return height; // 返回当前节点的高度
    }
}
