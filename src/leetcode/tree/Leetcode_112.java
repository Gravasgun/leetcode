package leetcode.tree;

import java.util.Stack;

/**
 * 112.路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 */
public class Leetcode_112 {
    /**
     * 方法一：迭代
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSumMethodOne(TreeNode root, int targetSum) {
        if (root == null) { // 如果根节点为空，直接返回false
            return false;
        }
        Stack<Object> stack = new Stack<>(); // 创建一个栈用于DFS
        stack.push(root); // 将根节点压入栈中
        stack.push(root.val); // 将根节点的值也压入栈中
        while (!stack.isEmpty()) { // 当栈不为空时进行循环
            int value = (int) stack.pop(); // 从栈中取出当前节点的值
            TreeNode temp = (TreeNode) stack.pop(); // 从栈中取出当前节点
            if (temp.left == null && temp.right == null && value == targetSum) {
                // 如果当前节点为叶子节点，并且其值等于目标和，那么就返回true
                return true;
            }
            if (temp.right != null) { // 如果当前节点有右子树，将其右子树压入栈中
                stack.push(temp.right);
                stack.push(value + temp.right.val); // 将右子树的值加上当前节点的值压入栈中
            }
            if (temp.left != null) { // 如果当前节点有左子树，将其左子树压入栈中
                stack.push(temp.left);
                stack.push(value + temp.left.val); // 将左子树的值加上当前节点的值压入栈中
            }
        }
        return false; // 循环结束后，仍然没有找到符合条件的路径，则返回false
    }

    /**
     * 方法二：递归
     *
     * @param root
     * @param targetsum
     * @return
     */
    public boolean haspathsum(TreeNode root, int targetsum) {
        if (root == null) { // 如果根节点为空，直接返回false
            return false;
        }
        targetsum -= root.val; // 计算剩余的目标和
        // 如果已经到达叶子结点
        if (root.left == null && root.right == null) {
            return targetsum == 0; // 判断剩余的目标和是否为0，如果是，返回true，否则返回false
        }
        if (root.left != null) { // 如果左子树不为空
            boolean left = haspathsum(root.left, targetsum); // 递归遍历左子树
            if (left) { // 如果找到了符合条件的路径，直接返回true
                return true;
            }
        }
        if (root.right != null) { // 如果右子树不为空
            boolean right = haspathsum(root.right, targetsum); // 递归遍历右子树
            if (right) { // 如果找到了符合条件的路径，直接返回true
                return true;
            }
        }
        return false; // 如果左右子树都遍历完了，也没有找到符合条件的路径，返回false
    }
}

