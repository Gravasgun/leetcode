package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101.对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class Leetcode_101 {
    /**
     * 方法一：广度优先搜索
     * @param root
     * @return
     */
    public boolean isSymmetricMethodOne(TreeNode root) {
        // 如果根节点为空，则直接返回true
        if (root == null) {
            return true;
        }
        // 使用队列来进行BFS（广度优先搜索）
        Queue<TreeNode> queue = new LinkedList<>();
        // 首先将左右子树的根节点加入队列中
        queue.offer(root.left);
        queue.offer(root.right);
        // 如果队列不为空，就一直循环
        while (!queue.isEmpty()) {
            // 从队列中取出两个节点，分别代表左子树和右子树中的当前节点
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            // 如果这两个节点都为空，则跳过本次循环
            if (left == null && right == null) {
                continue;
            }
            // 如果其中一个节点为空，则返回false
            if (left == null || right == null) {
                return false;
            }
            // 如果这两个节点的值不相等，则返回false
            if (left.val != right.val) {
                return false;
            }
            // 将左子树的左子节点和右子树的右子节点，以及左子树的右子节点和右子树的左子节点依次加入队列中
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        // 如果在循环中没有返回false，那么就是对称二叉树
        return true;
    }

    /**
     * 方法二：递归(深度优先搜索)
     * @param root
     * @return
     */
    public boolean isSymmetricMethodTwo(TreeNode root) {
        // 调用递归函数，比较左右子树是否对称
        return compare(root.left, root.right);
    }

    /**
     * 递归方法
     * @param left
     * @param right
     * @return
     */
    private boolean compare(TreeNode left, TreeNode right) {
        // 如果左子节点为空，右子节点非空，则不对称
        if (left == null && right != null) {
            return false;
        }
        // 如果左子节点非空，右子节点为空，则不对称
        if (left != null && right == null) {
            return false;
        }
        // 如果左右子节点均为空，则对称
        if (left == null && right == null) {
            return true;
        }
        // 如果左右子节点的值不相等，则不对称
        if (left.val != right.val) {
            return false;
        }
        // 比较左子节点的左子节点和右子节点的右子节点，以及左子节点的右子节点和右子节点的左子节点是否对称
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        // 如果左右子树均对称，则整棵树对称
        return outside && inside;
    }
}