package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 110.平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 一个二叉树每个 节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class Leetcode_110 {
    /**
     * 递归判断二叉树是否是平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        // 如果根节点为 null，那么它是平衡的
        if (root == null) {
            return true;
        }
        // 单层逻辑，判断以当前节点作为根节点的二叉树是否是平衡二叉树
        // 获取左子树和右子树的高度
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        // 如果左子树和右子树高度差大于1，那么它不平衡，返回 false
        if (Math.abs(rightHeight - leftHeight) > 1) {
            return false;
        }
        // 递归检查当前节点的左子树和右子树是否平衡，如果都平衡则整个树平衡
        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 层序遍历求高度
     *
     * @param temp
     * @return
     */
    public int getHeight(TreeNode temp) {
        // 如果当前节点为 null，那么高度为0
        if (temp == null) {
            return 0;
        }
        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        // 将当前节点加入队列
        queue.offer(temp);
        // 当队列不为空时，说明还有节点未处理，继续遍历
        while (!queue.isEmpty()) {
            // 获取当前层节点数量
            int size = queue.size();
            // 遍历当前层节点
            while (size-- > 0) {
                temp = queue.poll();
                // 如果有左子节点，将左子节点加入队列
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                // 如果有右子节点，将右子节点加入队列
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            // 处理完一层节点，高度加1
            height++;
        }
        // 返回整个树的高度
        return height;
    }
}
