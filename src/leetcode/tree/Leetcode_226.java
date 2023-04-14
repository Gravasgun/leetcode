package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 226.翻转二叉树
 * 给你一棵二叉树的根节点root ，翻转这棵二叉树，并返回其根节点。
 */
public class Leetcode_226 {
    /**
     * 方法一：递归
     * 使用前序或者后续都可以
     *
     * @param root
     * @return
     */
    public TreeNode invertTreeMethodOne(TreeNode root) {
        // 如果根节点为空，则直接返回null
        if (root == null) {
            return null;
        }
        // 保存根节点
        TreeNode result = root;
        // 交换左右子节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 递归翻转左子树和右子树
        invertTreeMethodOne(root.left);
        invertTreeMethodOne(root.right);
        // 返回根节点
        return result;
    }

    /**
     * 方法二：广度优先搜索
     *
     * @param root
     * @return
     */
    public TreeNode invertTreeMethodTwo(TreeNode root) {
        // 创建一个队列，用于广度优先搜索
        Queue<TreeNode> queue = new LinkedList<>();
        // 如果根节点为空，直接返回null
        if (root == null) {
            return null;
        }
        // 将根节点加入队列
        TreeNode temp = root;
        queue.offer(temp);
        while (!queue.isEmpty()) {
            // 获取当前队列的长度，即当前层的节点数
            int size = queue.size();
            // 遍历当前层的所有节点
            while (size-- > 0) {
                // 取出队首节点
                temp = queue.poll();
                // 交换当前节点的左右子节点
                TreeNode current = temp.left;
                temp.left = temp.right;
                temp.right = current;
                // 如果左子节点不为空，将其加入队列
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                // 如果右子节点不为空，将其加入队列
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        // 返回翻转后的树的根节点
        return root;
    }

    /**
     * 方法三：迭代法
     *
     * @param root
     * @return
     */
    public TreeNode invertTreeMethodThree(TreeNode root) {
        // 如果根节点为空，直接返回null
        if (root == null) {
            return null;
        }
        // 创建一个栈，用于存储待遍历的节点
        Stack<TreeNode> stack = new Stack<>();
        // 将根节点加入栈
        TreeNode temp = root;
        stack.push(temp);
        while (!stack.isEmpty()) {
            // 取出栈顶节点
            temp = stack.pop();
            // 交换当前节点的左右子节点
            TreeNode current = temp.left;
            temp.left = temp.right;
            temp.right = current;
            // 如果右子节点不为空，将其加入栈
            if (temp.right != null) {
                stack.push(temp.right);
            }
            // 如果左子节点不为空，将其加入栈
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        // 返回翻转后的树的根节点
        return root;
    }
}